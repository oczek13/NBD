package com.base.dao.repositories;

import com.base.model.Room;
import com.base.model.UniqueIdCodecProvider;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.conversions.Bson;

public class RoomRepository extends AbstractMongoRepository {

    public RoomRepository() {
        super("rooms", Room.class);
    }

    public Room findByRoomNumber(Integer roomNumber) {
        MongoCollection<Room> collection = mongoHotel.getCollection(collectionName, Room.class);
        Bson filter = Filters.eq("roomNumber", roomNumber);
        Room found = collection.find().filter(filter).first();
        return found;
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
                    Updates.set("possibleForRent", room.getPossibleForRent())
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
    }
}
