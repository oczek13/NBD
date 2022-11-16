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

    public Client registerClient(String firstname, String lastname, String personalID, String type) {
        Client client;
        //if(clientRepository.findByPersonalID(personalID) == null){
            if (type == "Normal" || type == "NORMAL" || type == "normal") {
                client = new Normal(firstname, lastname, personalID, type);
                clientRepository.add(client);
            } else if (type == "Premium" || type == "PREMIUM" || type == "premium") {
                client = new Premium(firstname, lastname, personalID, type);
                clientRepository.add(client);
            }
            else {
                throw new RuntimeException("Niepoprawny typ klienta");
            }

        return client;
    }

    public void unregisterClient(String personalID) throws Exception {
        Client client = clientRepository.findByPersonalID(personalID);
        client.setArchived(true);
        clientRepository.update(client);
    }

}

