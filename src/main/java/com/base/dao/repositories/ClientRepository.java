// Oczek13 zrobił syf na GitHubie :)

package com.base.dao.repositories;
import com.base.model.Client;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;

public class ClientRepository extends AbstractMongoRepository<Client> {
    public ClientRepository() {
        super("clients", Client.class);
    }

    public Client findByPersonalID(String personalID) {
        MongoCollection<Client> collection = mongoHotel.getCollection(collectionName, Client.class);
        Bson filter = Filters.eq("personalid", personalID);
        return collection.find().filter(filter).first();
    }

    public void update(Client client) {
        ClientSession clientSession = mongoClient.startSession();
        try {
            clientSession.startTransaction();
            MongoCollection<Client> clientsCollection = mongoHotel.getCollection(collectionName, Client.class);
            Bson filter = Filters.eq("_id", client.getEntityId());

            Bson setUpdate = Updates.combine(
                    Updates.set("personalid", client.getPersonalID()),
                    Updates.set("firstname", client.getFirstName()),
                    Updates.set("lastname", client.getLastName()),
                    Updates.set("type", client.getType())
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
        MongoCollection<Client> collection = mongoHotel.getCollection(collectionName, Client.class);
        collection.drop();
    }
}

