//package com.base.managers;
//
//import com.base.dao.repositories.ClientRepository;
//import com.base.model.Client;
//import com.base.model.ClientType;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityTransaction;
//import jakarta.transaction.Transactional;
//
//
//public class ClientManager {
//    ClientRepository clientRepository;
//
//    public ClientManager(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }
//}
//
//    ClientRepository currentClients;
//    ClientRepository archivedClients;
//    @Transactional
//    public void registerClient(){
//        EntityManager em = getEntityManager();
///       em.getTransaction().begin();
//        Client client = new Client();
//        em.persist(client);
//        em.getTransaction().commit();
//        //currentClients.add(new Client());
//    }
//
//    public void unregisterClient(Client client){
//        currentClients.remove(client);
//        archivedClients.add(client);
//    }









