package com.base.dao;

import com.base.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository implements Repository<Room> {
    private List<Room> rooms = new ArrayList<>();

    @Override
    public Integer add(Room obj) {
        rooms.add(obj);
        return null;
    }

    @Override
    public void remove(Room obj) {
        if (rooms.isEmpty()) return;
        else
            rooms.remove(obj);
    }

    @Override
    public Room findByID(Integer id) {
        if (rooms.isEmpty()) return null;
        Room auxiliaryRoom = new Room();
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(id)) {
                auxiliaryRoom = room;
            }
        }
        return auxiliaryRoom;
    }

    @Override
    public int quantity(){
        return rooms.size();
    }
}
