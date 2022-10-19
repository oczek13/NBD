package com.base.managers;

import com.base.dao.ClientRepository;
import com.base.model.Client;
import com.base.model.ClientType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import static com.base.dao.EntityManagerFactory.getEntityManager;


public class ClientManager {

    ClientRepository currentClients;
    ClientRepository archivedClients;

    public void registerClient(){

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Client client = new Client("Adam", "Malysz", 123, ClientType.NORMAL);

        em.persist(client);
        em.getTransaction().commit();
        //currentClients.add(new Client());
    }

    public void unregisterClient(Client client){
        currentClients.remove(client);
        archivedClients.add(client);
    }








}
