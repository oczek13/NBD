package com.base.managers;

import com.base.dao.RoomRepository;
import com.base.model.Room;

public class RoomManager {
    RoomRepository availableRooms;
    RoomRepository unavailableRooms;

    public void registerRoom(){
        availableRooms.add(new Room());
    }

    public void bookRoom(Room room){
        availableRooms.remove(room);
        unavailableRooms.add(room);
    }
}
