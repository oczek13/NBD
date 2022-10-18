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

    public void unregisterRent(Integer rentID){
        Rent currentRent = currentRents.findByID(rentID);
        currentRent.getRoom().setAvailable(true);
        currentRents.remove(currentRent);
        archivedRents.add(currentRent);
    }

    public void registerRent(Integer rentID, Client client, Room room, boolean archive, Date beginTime, Date endTime) throws Exception {
        try{ if (room.isAvailable() == true) {
            Rent rent = new Rent(rentID, client, room, false, new Date(), endTime);
            currentRents.add(rent);
            room.setAvailable(false);
        }}
        catch (Exception e){
            System.out.println("Pokoj niedostepny");
        };
    }
}

