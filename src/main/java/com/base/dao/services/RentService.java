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

    public RentService() {
        this.rentRepository = new RentRepository();
        this.roomRepository = new RoomRepository();
        this.clientRepository = new ClientRepository();
    }

    public boolean rentRoom(Client client, List<Room> rooms) {
        List<Rent> currentRents = findAllCurrentRents();
        List<Room> allRooms = new ArrayList<>();
        currentRents.forEach(rent -> allRooms.addAll(rent.getRooms()));
        if(checkRooms(allRooms, rooms)) {
            return false;
        }
        rooms.forEach
                (room -> {room.setPossibleForRent("No");
                          roomRepository.update(room);
                         });
        rentRepository.add(new Rent(client, rooms));
        return true;
    }

        public List<Rent> findAllCurrentRents() {
            return rentRepository.findAll();
        }

        private boolean checkRooms (List<Room> rooms, List<Room> rooms1){
            for (Room room: rooms)
            {
                    for (Room room1: rooms1)
                    {
                        if (Objects.equals(room.getEntityId(), room1.getEntityId())) return true;
                    }
            }
            return false;
            }

        public void endOfRent(Rent rent) {
            rentRepository.delete(rent.getEntityId().getUUID());
        }
        public Rent getRentByRoom(Integer roomNumber) {
            return rentRepository.findByRoom(roomRepository.findByRoomNumber(roomNumber));
        }

        public List<Rent> getRentByClient(String personalID){
            return rentRepository.findByClient(clientRepository.findByPersonalID(personalID));
        }
}
