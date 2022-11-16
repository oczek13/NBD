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
//        rooms.forEach
//                (room -> {room.setAvailable(false);
//                          roomRepository.update(room);
//                         });
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

//        private void checkIfBookCanBeRented(Client client, Room room) throws Exception {
//            if (client.isArchived()) {
//                throw new Exception("Klient jest zarchiwizowany");
//            }
//            if (!room.isAvailable()) {
//                throw new Exception("Pokój jest niedostępny");
//            }
//            if (rentRepository.findByRoom(room) != null) {
//                throw new Exception("Pokój jest właśnie wynajmowany");
//            }
//        }

        public void endOfRent(Integer roomNumber) {
            try {
                Room room = roomRepository.findByRoomNumber(roomNumber);
                if (room == null) {
                    throw new Exception("Nie ma pokoju o takim numerze");
                }
                Rent rent = rentRepository.findByRoom(room);
                if (rent == null) {
                    throw new Exception("Ten pokój nie jest wynajęty");
                }
                rentRepository.delete(rent.getEntityId().getUUID());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        public Rent getRentByRoom(Integer roomNumber) {
            return rentRepository.findByRoom(roomRepository.findByRoomNumber(roomNumber));
        }

        public List<Rent> getRentByClient(String personalID){
            return rentRepository.findByClient(clientRepository.findByPersonalID(personalID));
        }
}
