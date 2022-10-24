package com.base.dao.services;

import com.base.dao.repositories.ClientRepository;
import com.base.dao.repositories.RentRepository;
import com.base.dao.repositories.RoomRepository;
import com.base.model.Client;
import com.base.model.Rent;
import com.base.model.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentService {

    private final RentRepository rentRepository;
    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;

    public RentService(RentRepository rentRepository, ClientRepository clientRepository, RoomRepository roomRepository) {
        this.rentRepository = rentRepository;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
    }

    public boolean rentRoom(Client client, List<Room> rooms) {
        List<Rent> currentRents = findAllCurrentRents();
        List<Room> allRooms = new ArrayList<>();
        currentRents.forEach(rent -> allRooms.addAll(rent.getRooms()));
        if(checkRooms(allRooms, rooms)) {
            return false;
        }
        rooms.forEach
                (room -> {room.setAvailable(false);
                          roomRepository.update(room);
                         });
        rentRepository.add(new Rent(rooms, client));
        return true;
    }

        public List<Rent> findAllCurrentRents() {
            return rentRepository.findAll();
        }

        private boolean checkRooms (List<Room> rooms, List<Room> rooms1){
            for (Room room: rooms) {
                    for (Room room1: rooms1)
                    {
                        if (Objects.equals(room.getRoomID(), room1.getRoomID())) return true;
                    }
                                   }
            return false;
            }

}
