package com.base.managers;

import com.base.dao.RentRepository;
import com.base.model.Client;
import com.base.model.Rent;
import com.base.model.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class RentManager {
    private RentRepository currentRents;
    private RentRepository archivedRents;

    public void unregisterRent(String rentID){
        Rent currentRent = currentRents.findByID(rentID);
        currentRents.remove(currentRent);
        archivedRents.add(currentRent);
        Date endDate = new Date();
        currentRent.setEndTime(endDate);
        currentRent.getRoom().setAvailable(true);
    }

    public void registerRent(String rentID, Client client, Room room, boolean archive, Date beginTime, Date endTime) throws Exception {
        if (room.isAvailable() == true) {
            Rent rent = new Rent(rentID, client, room, false, beginTime, endTime);
            currentRents.add(rent);
            room.setAvailable(false);
        }
    }
}
