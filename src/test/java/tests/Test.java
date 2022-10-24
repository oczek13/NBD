package tests;


import com.base.dao.repositories.ClientRepository;
import com.base.dao.repositories.RentRepository;
import com.base.dao.repositories.RoomRepository;
import com.base.dao.services.ClientService;
import com.base.dao.services.RentService;
import com.base.dao.services.RoomService;
import com.base.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.constraints.AssertFalse;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.*;


public class Test {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HOTEL");
    private static EntityManager em;
    private RentRepository rentRepository;
    private RoomRepository roomRepository;
    private ClientRepository clientRepository;
    private RoomService roomService;
    private RentService rentService;
    private ClientService clientService;

    @BeforeEach
    void beforeEach() {
        em = entityManagerFactory.createEntityManager();
        this.roomRepository = new RoomRepository(em);
        this.clientRepository = new ClientRepository(em);
        this.rentRepository = new RentRepository(em);
        this.rentService = new RentService(rentRepository, clientRepository, roomRepository);
        this.clientService = new ClientService(clientRepository);
        this.roomService = new RoomService(roomRepository);

    }

    @org.junit.jupiter.api.Test
    public void roomRepositoryTest() {
        Room room = new Room(250, 1, 2, true);

        Room retrievedRoom = roomService.registerRoom(room);
        assertEquals((room.getBasePrice()), (retrievedRoom.getBasePrice()));

        roomService.unregisterRoom(retrievedRoom);
        assertNull((roomService.getRoomById(room.getRoomNumber())));
    }

    @org.junit.jupiter.api.Test
    public void clientRepositoryTest() {

        Client client = new Client("Piotr", "Wojtczak", 236699, new Premium());
        clientService.addClient(client);

        Client foundClient = clientService.getClientById(client.getId());
        assertEquals(client.getPersonal_ID(), foundClient.getPersonal_ID());

        clientService.removeClient(client);
        assertNull(clientService.getClientById(foundClient.getPersonal_ID()));
    }

    @org.junit.jupiter.api.Test
    public void RentRepositoryTest() {


        Client client1 = new Client("Michaś", "Oczko", 996632, new Normal());
        clientService.addClient(client1);
        Client client2 = new Client("Piotruś", "Wojtczak", 236699, new Premium());
        clientService.addClient(client2);
        Client client3 = new Client("Marian", "Paździoch", 123456, new Premium());
        clientService.addClient(client3);

        Room room1 = new Room(250, 1, 2, true);
        Room room2 = new Room(400, 2, 3, true);
        Room room3 = new Room(800, 3, 4, true);
        Room room4 = new Room(1100, 4, 2, true);
        roomService.registerRoom(room1);
        roomService.registerRoom(room2);
        roomService.registerRoom(room3);
        roomService.registerRoom(room4);

        List<Room> roomList = Arrays.asList(room1, room2);
        Rent rent = new Rent();
        rent.setRooms(roomList);

        List<Room> roomList1 = Arrays.asList(room3, room4);
        Rent rent1 = new Rent();
        rent1.setRooms(roomList1);

        rentService.rentRoom(client1, roomList);
        rentService.rentRoom(client2, roomList1);
        //assertFalse(rentService.rentRoom(client3, roomList));




    }
}
