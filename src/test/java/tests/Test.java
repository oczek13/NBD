//package tests;
//
//
//import com.base.dao.repositories.ClientRepository;
//import com.base.dao.repositories.RentRepository;
//import com.base.dao.repositories.RoomRepository;
//import com.base.dao.services.ClientService;
//import com.base.dao.services.RentService;
//import com.base.dao.services.RoomService;
//import com.base.model.*;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import org.junit.jupiter.api.BeforeEach;
//import java.util.Arrays;
//import java.util.List;
//import static org.testng.AssertJUnit.*;
//
//public class Test {
//    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HOTEL");
//    private static EntityManager em;
//    private RentRepository rentRepository;
//    private RoomRepository roomRepository;
//    private ClientRepository clientRepository;
//    private RoomService roomService;
//    private RentService rentService;
//    private ClientService clientService;
//
//    @BeforeEach
//    void beforeEach() {
//        em = entityManagerFactory.createEntityManager();
//        this.roomRepository = new RoomRepository(em);
//        this.clientRepository = new ClientRepository(em);
//        this.rentRepository = new RentRepository(em);
//        this.rentService = new RentService(rentRepository, clientRepository, roomRepository);
//        this.clientService = new ClientService(clientRepository);
//        this.roomService = new RoomService(roomRepository);
//
//    }
//
//    @org.junit.jupiter.api.Test
//    public void roomRepositoryTest() {
//        Room room = new Room(250, 1, 2, true);
//
//        Room retrievedRoom = roomService.registerRoom(room);
//        assertEquals((room.getBasePrice()), (retrievedRoom.getBasePrice()));
//
//        roomService.unregisterRoom(retrievedRoom);
//        assertNull((roomService.getRoomById(room.getRoomNumber())));
//    }
//
//    @org.junit.jupiter.api.Test
//    public void clientRepositoryTest() {
//
//        Client client = new Client("Piotr", "Wojtczak", 236699, new Premium());
//        clientService.addClient(client);
//
//        Client foundClient = clientService.getClientById(client.getId());
//        assertEquals(client.getPersonal_ID(), foundClient.getPersonal_ID());
//
////        clientService.removeClient(client);
////        assertNull(clientService.getClientById(foundClient.getPersonal_ID()));
//    }
//
//    @org.junit.jupiter.api.Test
//    public void RentRepositoryTest() {
//
//
//        Client client1 = new Client("Michaś", "Oczko", 996632, new Normal());
//        clientService.addClient(client1);
//        Client client2 = new Client("Piotruś", "Wojtczak", 236699, new Premium());
//        clientService.addClient(client2);
//        Client client3 = new Client("Marian", "Paździoch", 123456, new Premium());
//        clientService.addClient(client3);
//
//        Room room1 = new Room(250, 1, 2, true);
//        Room room2 = new Room(400, 2, 3, true);
//        Room room3 = new Room(800, 3, 4, true);
//        Room room4 = new Room(1100, 4, 2, true);
//        roomService.registerRoom(room1);
//        roomService.registerRoom(room2);
//        roomService.registerRoom(room3);
//        roomService.registerRoom(room4);
//
//        List<Room> roomList = Arrays.asList(room1, room2);
//        Rent rent = new Rent();
//        rent.setRooms(roomList);
//
//        List<Room> roomList1 = Arrays.asList(room3, room4);
//        Rent rent1 = new Rent();
//        rent1.setRooms(roomList1);
//
//        rentService.rentRoom(client1, roomList);
//        rentService.rentRoom(client2, roomList1);
//        assertFalse(rentService.rentRoom(client3, roomList));
//    }
//}


package tests;

import com.base.dao.repositories.ClientRepository;
import com.base.dao.repositories.RentRepository;
import com.base.dao.repositories.RoomRepository;
import com.base.dao.services.ClientService;
import com.base.dao.services.RentService;
import com.base.dao.services.RoomService;
import com.base.model.Room;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class mainTest {


    private ClientService clientService;
    private RoomService roomService;
    private RentService rentService;
    private RoomRepository roomRepository;
    private RentRepository rentRepository;
    private ClientRepository clientRepository;


   // @BeforeAll
//    void beforeAll() {
//        this.roomRepository = new RoomRepository();
//        this.clientRepository = new ClientRepository();
//        this.rentRepository = new RentRepository();
//    }

    @BeforeEach
    void beforeEach() {
        this.clientService = new ClientService();
        this.roomService = new RoomService();
        this.rentService = new RentService();
//        clientRepository.clearDatabase();
//        rentRepository.clearDatabase();
//        roomRepository.clearDatabase();
    }

    @Test
    void addSameObjects() throws Exception {
        List<Room> rooms = new ArrayList<>();
        roomService.registerRoom(200.0, 2, 3, true);
        var room = roomService.findByRoomNumber(2);
        rooms.add(room);
        clientService.registerClient("Robert", "Kubica", "123", "premium");
        var client = clientService.getClient("123");
        rentService.rentRoom(client, rooms);
    }
}

//        //clientManager.registerClient("imie", "naziwsko", "231312341", 45);
//
//        var xd = clientManager.getClient("231312341");
//        clientManager.registerClient("dziecko", "naziwsko", "2313123341", 13);
//
//    }
//
//    @Test
//    void addSameObjects2() throws Exception {
//
//        clientManager.registerClient("imie", "naziwsko", "231312341", 45);
//        clientManager.registerClient("dziecko", "naziwsko", "2313123341", 13);
//
//        bookManager.registerBook("najlepssza ksiega", "najlepszy autor", "2131341", "genre");
//        rentManager.rentBook("2313123341", "2131341");
//        assertThrows(Exception.class, () -> {
//            rentManager.rentBook("2313123341", "2131341");
//        });
//        assertThrows(Exception.class, () -> {
//            bookManager.registerBook("najlepssza ksiega", "najlepszy autor", "2131341", "genre");
//        });
//        assertThrows(Exception.class, () -> {
//            clientManager.registerClient("dziecko", "naziwsko", "2313123341", 13);
//        });
//    }
//
//
//    @Test
//    void checkTooMuchRents() throws Exception {
//        var client1 = clientManager.registerClient("imie", "naziwsko", "231312341", 45);
//        var client2 = clientManager.registerClient("dziecko", "naziwsko", "2313123341", 13);
//        var book1 = bookManager.registerBook("najlepssza ksiega1", "najlepszy autor1", "21313412", "genre");
//        var book2 = bookManager.registerBook("najlepssza ksiega2", "najlepszy autor2", "21313413", "genre");
//        var book3 = bookManager.registerBook("najlepssza ksiega3", "najlepszy autor3", "21313414", "genre");
//        var book4 = bookManager.registerBook("najlepssza ksiega4", "najlepszy autor4", "21313415", "genre");
//        var book5 = bookManager.registerBook("najlepssza ksiega5", "najlepszy autor5", "21313411", "genre");
//        var book6 = bookManager.registerBook("najlepssza ksiega5", "najlepszy autor5", "21313416", "genre");
//        rentManager.rentBook("2313123341", "21313412");
//        rentManager.rentBook("2313123341", "21313413");
//        rentManager.rentBook("2313123341", "21313414");
//        assertThrows(Exception.class, () -> {
//            rentManager.rentBook("2313123341", "21313416");
//        });
//    }
//
//    @Test
//    void checkUnregisterClientAndBook() throws Exception {
//        clientManager.registerClient("imie", "naziwsko", "231312341", 45);
//        clientManager.registerClient("dziecko", "naziwsko", "2313123341", 13);
//        bookManager.registerBook("najlepssza ksiega1", "najlepszy autor1", "21313412", "genre");
//        bookManager.registerBook("najlepssza ksiega2", "najlepszy autor2", "21313413", "genre");
//        clientManager.unregisterClient("231312341");
//        bookManager.unregisterBook("21313412");
//        assertTrue(clientManager.getClient("231312341").isArchived());
//        assertTrue(bookManager.getBook("21313412").isArchived());
//        rentManager.rentBook("2313123341", "21313413");
//        assertThrows(Exception.class, () -> {
//            clientManager.unregisterClient("2313123341");
//        });
//        assertThrows(Exception.class, () -> {
//            bookManager.unregisterBook("21313413");
//        });
//    }
//    @Test
//    void concurrentCheckTest() throws Exception {
//
//        clientManager.registerClient("imie", "naziwsko", "231312341", 45);
//        clientManager.registerClient("dziecko", "naziwsko", "2313123341", 13);
//        bookManager.registerBook("najlepssza ksiega1", "najlepszy autor1", "21313412", "genre");
//        var client = clientManager.getClient("231312341");
//        Client client2 = clientManager.getClient("2313123341");
//        Book book = bookManager.getBook("21313412");
//        BookManager bookManager1 = new BookManager();
//        Book book2 = bookManager1.getBook("21313412");
//        Rent rent = new Rent(client,book);
//        rentRepository.add(rent);
//        bookRepository.incrementIsRented(book);
//        bookRepository.incrementIsRented(book2);
//
//    }
//
//
//}
