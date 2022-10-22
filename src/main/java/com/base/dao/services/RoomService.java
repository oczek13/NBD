package com.base.dao.services;

import com.base.dao.repositories.RoomRepository;
import com.base.model.Room;

import java.util.List;

public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room getRoomById (int id){
        return roomRepository.getById(id);
    }

    public List<Room> findAllBooks() {
        return roomRepository.findAll();
    }

    public Room registerRoom(double basePrice, int roomNumber, int roomCapacity, boolean isAvailable ){
        return roomRepository.add(new Room(basePrice, roomNumber, roomCapacity, isAvailable));
    }

    public void unregisterRoom(Room room) {
        roomRepository.remove(room);
    }
}
