package com.base.managers;

import com.base.dao.ClientRepository;
import com.base.model.Client;


public class ClientManager {
    ClientRepository clientRepository;

    public void registerClient(){
        clientRepository.add(new Client());
    }

    public void unregisterClient(Client client){
        clientRepository.remove(client);
    }




}
