package com.base.dao.services;

import com.base.dao.repositories.ClientRepository;
import com.base.model.Client;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientById(int id) {
        return clientRepository.getById(id);
    }

    public Client addClient(Client client) {
        return clientRepository.add(client);
    }

    public void removeClient(Client client) {
        clientRepository.delete(client);
    }
}
