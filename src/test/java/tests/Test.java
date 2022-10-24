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
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        Room retrievedRoom = roomService.registerRoom(250, 1, 2, true);
        assertTrue((room.getBasePrice()) == (retrievedRoom.getBasePrice()));
        roomService.unregisterRoom(retrievedRoom);
        assertTrue((roomService.getRoomById(room.getRoomNumber())) == null);
    }

    @org.junit.jupiter.api.Test
    public void clientRepositoryTest() {
        Client client = new Client("Piotr", "Wojtczak", 236699, new Premium());
        clientService.addClient(client);
        Client foundClient = clientService.getClientById(client.getId());
        assertTrue(Objects.equals(client.getPersonal_ID(), foundClient.getPersonal_ID()));
        clientService.removeClient(client);
        assertTrue(clientService.getClientById(foundClient.getPersonal_ID()) == null);
    }

    @org.junit.jupiter.api.Test
    public void RentRepositoryTest() {
        Client client1 = new Client("Michaś", "Oczko", 996632, new Normal());
        Room room1 = new Room(250, 1, 2, true);
        Room room2 = new Room(400, 2, 3, true);
        List<Room> roomList = Arrays.asList(room1, room2);
        Rent rent = new Rent();
        rent.setRooms(roomList);
        clientService.addClient(client1);
        roomService.registerRoom(250, 1, 2, true);
        roomService.registerRoom(400, 2, 3, true);
        rentService.rentRoom(client1, roomList);
        Client client2 = new Client("Piotruś", "Wojtczak", 236699, new Premium());
        clientService.addClient(client2);
        assertFalse(rentService.rentRoom(client2, roomList));
    }
}
