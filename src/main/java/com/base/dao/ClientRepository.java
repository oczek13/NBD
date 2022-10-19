package com.base.dao;

import com.base.model.Client;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements Repository<Client> {
    private List<Client> clients = new ArrayList<>();

    @Transactional
    @Override
    public Integer add(Client obj) {
        clients.add(obj);
        return obj.getPersonalID();
    }


    @Transactional
    @Override
    public void remove(Client obj) {
        if (clients.isEmpty()) return;
        else {
            clients.remove(obj);
        }
    }

    @Transactional
    @Override
    public Client findByID(Integer id) {
        if (clients.isEmpty()) return null;
        Client auxiliaryClient = new Client();
        for (Client client : clients) {
            if (client.getPersonalID().equals(id)) {
                auxiliaryClient = client;
            }
        }
        return auxiliaryClient;
    }

    @Override
    public int quantity(){
        return clients.size();
    }
}

// Oczek13 zrobił syf na GitHubie :)