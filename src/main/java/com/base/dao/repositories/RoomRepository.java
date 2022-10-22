package com.base.dao.repositories;

import com.base.model.Room;
import jakarta.persistence.EntityManager;
import java.util.List;


public class RoomRepository extends RepositoryImpl<Room> {


    public RoomRepository(EntityManager em) {
        super(em);
    }

    @Override
    public List<Room> findAll() {
        return em.createQuery("Select room from Room room", Room.class).getResultList();
    }

    @Override
    public Room getById(int id) {
        return em.find(Room.class, id);
    }
}