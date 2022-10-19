package com.base.dao;

import com.base.util.EntityManagerCreator;
import com.base.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.base.model.Client_.personalID;

public class ClientRepository implements Repository<Client> {

    @Override
    public void add(Client obj) {
        try (EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
        }
    }

    @Override
    public void remove(Client obj) {
        try (EntityManager entityManager = EntityManagerCreator.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(obj));
            entityManager.getTransaction().commit();
        }
    }

    public Client get(Integer id){
        try(EntityManager entityManager = EntityManagerCreator.getEntityManager()){
            return entityManager.find(Client.class, personalID);
        }
    }
}

//    @Transactional
//    @Override
//    public Client findByID(Integer id) {
//        if (clients.isEmpty()) return null;
//        Client auxiliaryClient = new Client();
//        for (Client client : clients) {
//            if (client.getPersonalID().equals(id)) {
//                auxiliaryClient = client;
//            }
//        }
//        return auxiliaryClient;
//    }
//
//    @Override
//    public int quantity(){
//        return clients.size();
//    }
//}

// Oczek13 zrobił syf na GitHubie :)