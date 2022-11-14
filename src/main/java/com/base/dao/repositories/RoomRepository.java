//package com.base.dao.repositories;
//
//import com.base.model.Room;
//import jakarta.persistence.EntityManager;
//import java.util.List;
//
//
//public class RoomRepository extends RepositoryImpl<Room> {
//
//
//    public RoomRepository(EntityManager em) {
//        super(em);
//    }
//
//    @Override
//    public List<Room> findAll() {
//        return em.createQuery("Select room from Room room", Room.class).getResultList();
//    }
//
//    @Override
//    public Room getById(int id) {
//        return em.find(Room.class, id);
//    }
//}


package com.base.dao.repositories;


import com.base.model.Room;
import com.base.model.UniqueIdCodecProvider;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCommandException;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.ValidationOptions;
import library.model.Book;
import library.model.UniqueIdCodecProvider;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.conversions.Bson;

public class BookRepository extends AbstractMongoRepository {


    public BookRepository() {
        super("books", Room.class);
    }
    public Room findByRoomNumber(Integer roomNumber) {
        MongoCollection<Room> collection = mongoHotel.getCollection(collectionName, Room.class);
        Bson filter = Filters.eq("roomNumber", roomNumber);
        return collection.find().filter(filter).first();
    }

    public void update(Room room) {

        ClientSession clientSession = mongoClient.startSession();
        try {
            clientSession.startTransaction();
            MongoCollection<Room> roomsCollection = mongoHotel.getCollection(collectionName, Room.class);
            Bson filter = Filters.eq("_id", room.getEntityId());

            Bson setUpdate = Updates.combine(
                    Updates.set("basePrice", room.getBasePrice()),
                    Updates.set("roomNumber", room.getRoomNumber()),
                    Updates.set("roomCapacity", room.getRoomCapacity()),
                    Updates.set("isAvailable", room.isAvailable())
            );

            roomsCollection.updateOne(clientSession, filter, setUpdate);
            clientSession.commitTransaction();
        } catch (Exception e) {
            clientSession.abortTransaction();
        } finally {
            clientSession.close();
        }

    }

    public void clearDatabase() {
        MongoCollection<Room> collection = mongoHotel.getCollection(collectionName, Room.class);
        collection.drop();
    }

//    public void incrementIsRented(Room room) {
//        ClientSession clientSession = mongoClient.startSession();
//        try {
//            clientSession.startTransaction();
//            MongoCollection<Book> booksCollection = mongoDatabase.getCollection(collectionName, Book.class);
//            Bson filter = Filters.eq("_id", book.getEntityId());
//            Bson update = Updates.inc("rented",1);
//            booksCollection.updateOne(clientSession,filter,update);
//            clientSession.commitTransaction();
//        } catch (Exception e) {
//            clientSession.abortTransaction();
//        } finally {
//            clientSession.close();
//        }
//    }

    @Override
    protected void initDbConnection() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .applyConnectionString(connectionString)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .codecRegistry(CodecRegistries.fromRegistries(
                        CodecRegistries.fromProviders(new UniqueIdCodecProvider()),
                        MongoClientSettings.getDefaultCodecRegistry(),
                        pojoCodecRegistry)
                ).build();
        mongoClient = MongoClients.create(settings);
        mongoHotel = mongoClient.getDatabase("hotel");
        ValidationOptions validationOptions = new ValidationOptions().validator(
                Document.parse("""
                        {
                            $jsonSchema:{
                                "bsonType": "object",
                                "required": ["_id","rented"]
                                "properties": {
                                    "rented": {
                                        "bsonType" : "int",
                                        "minimum" : 0,
                                        "maximum" : 1
                                    }
                                }
                            }
                        }
                        """));
        CreateCollectionOptions createCollectionOptions = new CreateCollectionOptions()
                .validationOptions(validationOptions);
        try {
            mongoHotel.createCollection("rooms", createCollectionOptions);
        } catch (Exception e) {

        }
    }
}
