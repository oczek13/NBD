package com.base.dao.repositories;

import com.base.model.Client;
import com.base.model.Rent;
import com.base.model.Room;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.List;

public class RentRepository extends AbstractMongoRepository {


    public RentRepository() {
        super("rents", Rent.class);
    }
    public List<Rent> findByClient(Client client) {
        MongoCollection<Rent> collection = mongoHotel.getCollection(collectionName, Rent.class);
        Bson filter = Filters.eq("client._id", client.getEntityId());
        return collection.find().filter(filter).into(new ArrayList<>());
    }
    public Rent findByRoom(Room room) {
        MongoCollection<Rent> collection = mongoHotel.getCollection(collectionName, Rent.class);
        Bson filter = Filters.eq("room._id", room.getEntityId());
        return collection.find().filter(filter).first();
    }
    public void update(Rent rent) {
        ClientSession clientSession = mongoClient.startSession();
        try {
            clientSession.startTransaction();
            MongoCollection<Rent> clientsCollection = mongoHotel.getCollection(collectionName, Rent.class);
            Bson filter = Filters.eq("_id", rent.getEntityId());
            Bson setUpdate = Updates.combine(
                    Updates.set("client", rent.getClient()),
                    Updates.set("room", rent.getRooms())
            );
            clientsCollection.updateOne(clientSession, filter, setUpdate);
            clientSession.commitTransaction();
        } catch (Exception e) {
            clientSession.abortTransaction();
        } finally {
            clientSession.close();
        }

    }
    public void clearDatabase() {
        MongoCollection<Rent> collection = mongoHotel.getCollection(collectionName, Rent.class);
        collection.drop();
    }



}

