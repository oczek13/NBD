package com.base.front;

import com.base.dao.ClientRepository;
import com.base.managers.ClientManager;
import com.base.model.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class MainApp {
    public static void main(String[] args) {
        ClientManager clientManager = new ClientManager();
        clientManager.registerClient("paul");
    }
}
