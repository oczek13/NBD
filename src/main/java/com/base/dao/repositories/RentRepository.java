package com.base.dao.repositories;

import com.base.model.Client;
import com.base.model.Rent;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import jakarta.persistence.EntityManager;
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
    @Override
    public List<Rent> findAll() {
        return em.createQuery("Select rent from Rent rent", Rent.class).getResultList();
    }
}

