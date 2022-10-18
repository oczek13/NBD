package com.base.dao;

import com.base.model.Rent;
import com.base.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository implements Repository<Room> {
    private List<Room> rooms = new ArrayList<>();

    @Override
    public void add(Room obj) {
        rooms.add(obj);
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
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNumber() == id) {
                return rooms.get(i);
            }
        }
        return null;
    }
}
