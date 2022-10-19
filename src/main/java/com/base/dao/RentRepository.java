package com.base.dao;

import com.base.model.Client;
import com.base.model.Rent;
import com.base.util.EntityManagerCreator;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static com.base.model.Client_.personalID;
import static com.base.model.Rent_.rentID;

public class RentRepository implements Repository<Rent>{

    public void add(Rent obj){
        try(EntityManager entityManager = EntityManagerCreator.getEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(obj);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public void remove(Rent obj) {
        try (EntityManager entityManager = EntityManagerCreator.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(obj));
            entityManager.getTransaction().commit();
        }
    }

    public Rent get(Integer id){
        try(EntityManager entityManager = EntityManagerCreator.getEntityManager()){
            return entityManager.find(Rent.class, rentID);
        }
    }
}

//    @Override
//    public Rent findByID(Integer id) {
//        if (rents.isEmpty()) return null;
//        Rent auxiliaryRent = new Rent();
//        for (Rent rent : rents) {
//            if (rent.getRentID().equals(id)) {
//                auxiliaryRent = rent;
//            }
//        }
//        return auxiliaryRent;
//    }



//    @Override
//    public int quantity(){
//        return rents.size();
//    }

