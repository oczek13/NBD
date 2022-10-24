package com.base.dao.services;

import com.base.dao.repositories.ClientRepository;
import com.base.dao.repositories.RentRepository;
import com.base.dao.repositories.RoomRepository;
import com.base.model.Client;
import com.base.model.Rent;
import com.base.model.Room;
import java.util.ArrayList;
import java.util.List;

public class RentService {

    private final RentRepository rentRepository;
    private final ClientRepository clientRepository;
    private final RoomRepository bookRepository;

    public RentService(RentRepository rentRepository, ClientRepository clientRepository, RoomRepository bookRepository) {
        this.rentRepository = rentRepository;
        this.clientRepository = clientRepository;
        this.bookRepository = bookRepository;
    }

    public boolean rentRoom(Client client, List<Room> rooms) {
        List<Rent> currentRents = findAllCurrentRents();
        List<Room> allRooms = new ArrayList<>();
        currentRents.forEach(rent -> allRooms.addAll(rent.getRooms()));
        if(allRooms.hashCode() == rooms.hashCode()) {
            return false;
        }
        rentRepository.add(new Rent(rooms, client));

        return true;
    }

        public List<Rent> findAllCurrentRents() {
            return rentRepository.findAll();
        }
}
