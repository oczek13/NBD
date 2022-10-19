package com.base.dao;

import com.base.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements Repository<Client> {
    private List<Client> clients = new ArrayList<>();

    @Override
    public void add(Client obj) {
        clients.add(obj);
    }



    @Override
    public void remove(Client obj) {
        if(clients.isEmpty()) return;
        else
            clients.remove(obj);
    }

    @Override
    public Client findByID(Integer id) {
        if (clients.isEmpty()) return null;

        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getPersonalID() == id) {
                return clients.get(i);
            }
        }
        return null;
    }
}

// Oczek13 zrobił syf na GitHubie :)