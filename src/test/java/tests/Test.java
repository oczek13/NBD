package tests;

import com.base.dao.repositories.ClientRepository;
import com.base.dao.repositories.RentRepository;
import com.base.dao.repositories.RoomRepository;
import com.base.dao.services.ClientService;
import com.base.dao.services.RentService;
import com.base.dao.services.RoomService;
import com.base.model.Client;
import com.base.model.Premium;
import com.base.model.Rent;
import com.base.model.Room;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.exceptions;
import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class mainTest {

    private ClientService clientService;
    private RoomService roomService;
    private RentService rentService;
    private RoomRepository roomRepository;
    private RentRepository rentRepository;
    private ClientRepository clientRepository;

     @BeforeAll
        void beforeAll() {
            this.roomRepository = new RoomRepository();
            this.clientRepository = new ClientRepository();
            this.rentRepository = new RentRepository();
        }

    @BeforeEach
    void beforeEach() {
        this.clientService = new ClientService();
        this.roomService = new RoomService();
        this.rentService = new RentService();
        clientRepository.clearDatabase();
        rentRepository.clearDatabase();
        roomRepository.clearDatabase();
    }

    @Test
    void addSameObjects(){
          List<Room> rooms = new ArrayList<>();
          Room room = new Room(250, 1, 2, "Yes");
          roomService.registerRoom(room);
          rooms.add(room);
          Room room1 = new Room(250, 1, 2, "Yes");
          roomService.registerRoom(room1);
          Client client = new Premium("Bob", "Marlej", "420", "premium");
          clientService.registerClient(client);
          rentService.rentRoom(client, rooms);
    }

    @Test
    void deleteTest(){
        List<Room> rooms = new ArrayList<>();
        Room room = new Room(250, 1, 2, "Yes");
        roomService.registerRoom(room);
        rooms.add(room);
        roomService.unregisterRoom(room);
        assertEquals(0, roomService.findAllRooms().size());
    }

    @Test
    void updateTest(){
        List<Room> rooms = new ArrayList<>();
        Room room = new Room(250, 1, 2, "Yes");
        roomService.registerRoom(room);
        rooms.add(room);
        room.setBasePrice(10000);
        roomRepository.update(room);
        assertEquals(room.getBasePrice(), 10000);
    }

    @Test
    void getTest(){
        Room room = new Room(250, 1, 2, "Yes");
        roomService.registerRoom(room);
        assertEquals(room.getEntityId().getUUID(), roomService.findByRoomNumber(1).getEntityId().getUUID());
        Client client = new Premium("Bob", "Marlej", "420", "premium");
        clientService.registerClient(client);
        client.setFirstName("Jan");
        assertEquals(client.getFirstName(), "Jan");
    }

    @Test
    void findAllTest(){
        Room room = new Room(250, 1, 2, "Yes");
        Room room1 = new Room(300, 5, 4, "Yes");
        Room room2 = new Room(500, 3, 3, "Yes");

        roomService.registerRoom(room);
        roomService.registerRoom(room1);
        roomService.registerRoom(room2);

        assertEquals(roomService.findAllRooms().size(), 3);
    }
}