package com.base.managers;

import com.base.dao.RentRepository;
import com.base.model.Client;
import com.base.model.Rent;
import com.base.model.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class RentManager {

    RentRepository rentRepository;

    public RentManager(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public boolean isAvailable(Room room){
        if(room.isAvailable())return true;
        else return false;
    }

    public boolean tryRoom(Integer rentID, Client client, Room room, Date beginTime, Date endTime) throws Exception {
        if(!isAvailable(room)) return false;
        Rent rent = new Rent(rentID, client, room, beginTime, endTime);
        rentRepository.add(rent);
        return true;
    }
}

//    private RentRepository currentRents;
//    private RentRepository archivedRents;
//
//    public void unregisterRent(Integer rentID){
//        Rent currentRent = currentRents.findByID(rentID);
//        currentRent.getRoom().setAvailable(true);
//        currentRents.remove(currentRent);
//        archivedRents.add(currentRent);
//    }
//
//    public void registerRent(Integer rentID, Client client, Room room, boolean archive, Date beginTime, Date endTime) throws Exception {
//        try{ if (room.isAvailable() == true) {
//            Rent rent = new Rent(rentID, client, room, false, new Date(), endTime);
//            currentRents.add(rent);
//            room.setAvailable(false);
//        }}
//        catch (Exception e){
//            System.out.println("Pokoj niedostepny");
//        };
//    }
//}

