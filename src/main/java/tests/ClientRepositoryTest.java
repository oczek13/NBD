package tests;

import com.base.model.ClientType;
import org.junit.Assert;
import org.junit.Test;
import com.base.dao.ClientRepository;
import com.base.model.Client;

public class ClientRepositoryTest {
    Client client1 = new Client("Piotr", "Wojtczak", 236699, ClientType.PREMIUM);
    Client client2 = new Client("Michal", "Oczko", 996632, ClientType.NORMAL);

    @Test
    public void ClientRepositoryAddTest() {
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.add(client1);
        clientRepository.add(client2);
        Assert.assertEquals(clientRepository.quantity(),2);
    }
    @Test
    public void ClientRepositoryRemoveTest() {
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.add(client1);
        clientRepository.add(client2);
        clientRepository.remove(client2);
        Assert.assertEquals(clientRepository.quantity(),1);
    }
    @Test
    public void ClientRepositoryFindByPersonalIDTest() {
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.add(client1);
        clientRepository.add(client2);
        Assert.assertEquals(clientRepository.findByID(236699),client1);
        Assert.assertEquals(clientRepository.findByID(996632),client2);
    }

    @Test
    public void OczkoLastNameTest(){
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.add(client2);
        Assert.assertEquals(clientRepository.findByID(996632).getLastName(),"Oczko");
    }
}