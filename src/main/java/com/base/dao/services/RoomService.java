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

    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    public Room registerRoom(Room room){
        return roomRepository.add(room);
    }

    public void unregisterRoom(Room room) {
        roomRepository.delete(room);
    }
}
