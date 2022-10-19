package com.base.managers;

import com.base.dao.ClientRepository;
import com.base.model.Client;
import com.base.model.ClientType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import org.junit.Test;

import static com.base.dao.EntityManagerFactory.getEntityManager;

public class ClientManager {

    ClientRepository currentClients;
    ClientRepository archivedClients;
    @Transactional
    public void registerClient(){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Client client = new Client();
        em.persist(client);
        em.getTransaction().commit();
        //currentClients.add(new Client());
    }

    public void unregisterClient(Client client){
        currentClients.remove(client);
        archivedClients.add(client);
    }








}
