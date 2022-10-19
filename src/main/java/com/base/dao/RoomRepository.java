package com.base.dao;

import com.base.model.Client;
import com.base.model.Rent;
import com.base.model.Room;
import com.base.util.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.base.model.Client_.personalID;
import static com.base.model.Room_.roomNumber;


public class RoomRepository implements Repository<Room> {


    @Override
    public void add(Room obj) {
        try(EntityManager entityManager = EntityManagerCreator.getEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(obj);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public void remove(Room obj) {
        try (EntityManager entityManager = EntityManagerCreator.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(obj));
            entityManager.getTransaction().commit();
        }
    }

    public Room get(Integer id){
        try(EntityManager entityManager = EntityManagerCreator.getEntityManager()){
            return entityManager.find(Room.class, roomNumber);
        }
    }
}

//    @Override
//    public Room findByID(Integer id) {
//        if (rooms.isEmpty()) return null;
//        Room auxiliaryRoom = new Room();
//        for (Room room : rooms) {
//            if (room.getRoomNumber().equals(id)) {
//                auxiliaryRoom = room;
//            }
//        }
//        return auxiliaryRoom;
//    }
//
//    @Override
//    public int quantity(){
//        return rooms.size();
//    }
//}
