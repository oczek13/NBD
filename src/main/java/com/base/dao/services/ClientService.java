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
}

