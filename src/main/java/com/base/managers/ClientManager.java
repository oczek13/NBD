package com.base.managers;

import com.base.dao.ClientRepository;
import com.base.model.Client;


public class ClientManager {
    ClientRepository currentClients;
    ClientRepository archivedClients;

    public void registerClient(){
        currentClients.add(new Client());
    }

    public void unregisterClient(Client client){
        currentClients.remove(client);
        archivedClients.add(client);
    }




}
