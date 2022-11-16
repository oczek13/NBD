//package com.base.dao.services;
//
//import com.base.dao.repositories.ClientRepository;
//import com.base.model.Client;
//
//public class ClientService {
//    private final ClientRepository clientRepository;
//
//    public ClientService(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }
//
//    public Client getClientById(int id) {
//        return clientRepository.getById(id);
//    }
//
//    public Client addClient(Client client) {
//        return clientRepository.add(client);
//    }
//
//    public void removeClient(Client client) {
//        clientRepository.delete(client);
//    }
//}

package com.base.dao.services;

import com.base.dao.repositories.ClientRepository;
import com.base.dao.repositories.RentRepository;
import com.base.model.Client;
import com.base.model.Normal;
import com.base.model.Premium;

import java.util.List;

public class ClientService {
    private ClientRepository clientRepository;
    private RentRepository rentRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
        this.rentRepository = new RentRepository();
    }

    public Client getClient(String personalID) {
        return clientRepository.findByPersonalID(personalID);
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client registerClient(Client client) {
        //if(clientRepository.findByPersonalID(personalID) == null){
            if (client.getType() == "Normal" || client.getType() == "NORMAL" || client.getType() == "normal") {
                client = new Normal(client.getFirstName(), client.getLastName(), client.getPersonalID(), client.getType());
                clientRepository.add(client);
            } else if (client.getType() == "Premium" || client.getType() == "PREMIUM" || client.getType() == "premium") {
                client = new Premium(client.getFirstName(), client.getLastName(), client.getPersonalID(), client.getType());
                clientRepository.add(client);
            }
            else {
                throw new RuntimeException("Niepoprawny typ klienta");
            }

        return client;
    }

    public void unregisterClient(Client client) {
//        Client client = clientRepository.findByPersonalID(personalID);
        clientRepository.delete(client.getEntityId().getUUID());
    }

}

