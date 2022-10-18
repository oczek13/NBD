package com.base.managers;

import com.base.dao.ClientRepository;
import com.base.model.Client;


public class ClientManager {
    private ClientService clientService;

    public void registerClient(String firstName){
        Client client = new Client();
        client.setFirstName(firstName);
        clientService.registerClient(firstName);
    }
}
