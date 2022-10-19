package com.base.managers;

import com.base.dao.RoomRepository;
import com.base.model.Client;
import com.base.model.Room;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

//import static com.base.dao.EntityManagerFactory.getEntityManager;

public class RoomManager {
    RoomRepository roomRepository;

    public RoomManager(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
}
//    RoomRepository availableRooms;
//    RoomRepository unavailableRooms;
//
////    @Transactional
////    public void registerRoom(){
////        EntityManager em = getEntityManager();
////        em.getTransaction().begin();
////        Room room = new Room();
////        availableRooms.add(room);
////        em.persist(room);
////        em.getTransaction().commit();
////    }
//
//    public void bookRoom(Room room){
//        availableRooms.remove(room);
//        unavailableRooms.add(room);
//    }
//}
