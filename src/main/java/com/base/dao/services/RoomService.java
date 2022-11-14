package com.base.dao.services;

import com.base.dao.repositories.RentRepository;
import com.base.dao.repositories.RoomRepository;
import com.base.model.Room;
import java.util.List;

public class RoomService {
    private final RoomRepository roomRepository;
    private final RentRepository rentRepository;

    public RoomService() {
        this.roomRepository = new RoomRepository();
        this.rentRepository = new RentRepository();
    }

    public Room findByRoomNumber (int roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }


    public Room registerRoom(Room room) {
        roomRepository.add(room);
        return room;
    }

//    public Room registerRoom(double basePrice, int roomNumber, int capacity, boolean isAvailable) {
//        Room room = new Room(basePrice, roomNumber, capacity, isAvailable);
//        if(roomRepository.findByRoomNumber(roomNumber) == null){
//            roomRepository.add(room);
//        } else {
//            throw new RuntimeException("Ten pokój już istnieje w bazie danych!");
//        }
//        return room;
//    }

    public void unregisterRoom(Integer roomNumber) throws Exception {
        Room room = roomRepository.findByRoomNumber(roomNumber);
        if (rentRepository.findByRoom(room) != null) {
            throw new Exception("Ten pokój jest właśnie wynajmowany!");
        }
        room.setAvailable(false);
        roomRepository.update(room);
    }
    }
