package tests;


import com.base.dao.repositories.ClientRepository;
import com.base.dao.repositories.RentRepository;
import com.base.dao.repositories.RoomRepository;
import com.base.dao.services.ClientService;
import com.base.dao.services.RentServices;
import com.base.dao.services.RoomService;
import com.base.model.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class Test {
//    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HOTEL");
//    private static EntityManager em;
//    private RentRepository rentRepository;
//    private RoomRepository roomRepository;
//    private ClientRepository clientRepository;
//    private RoomService roomService;
//    private RentServices rentService;
//    private ClientService clientService;
//
//    @BeforeEach
//    void beforeEach() {
//        if (entityManagerFactory != null) {
//            entityManagerFactory.close();
//        }
//        em = entityManagerFactory.createEntityManager();
//        this.roomRepository = new RoomRepository(em);
//        this.clientRepository = new ClientRepository(em);
//        this.rentRepository = new RentRepository(em);
//        this.rentService = new RentServices(rentRepository, clientRepository, roomRepository);
//        this.clientService = new ClientService(clientRepository);
//        this.roomService = new RoomService(roomRepository);
//
//    }
//    @org.junit.jupiter.api.Test
//    public void roomRepositoryTest() {
//        Room room = new Room(250, 1, 2, true);
//        Room retrievedRoom = roomService.registerRoom(250, 1, 2, true);
//        assertTrue((room.getBasePrice()) == (retrievedRoom.getBasePrice()));
//        roomService.unregisterRoom(retrievedRoom);
//        retrievedRoom = roomService.getRoomById(retrievedRoom.getRoomNumber());
//        assertTrue((retrievedRoom) == null);
//    }
}
