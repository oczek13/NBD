package tests;


import com.base.model.Client;
import com.base.model.ClientType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {
private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HOTEL");
    @org.junit.jupiter.api.Test
    void method(){
        try(EntityManager e = entityManagerFactory.createEntityManager()){
            Client client1 = new Client("Michaś", "Oczko", ClientType.NORMAL);
            Client client2 = new Client("Piotr", "Wojtczak", ClientType.PREMIUM);
            e.getTransaction().begin();
            e.persist(client1);
            e.persist(client2);
            e.getTransaction().commit();
        }

    }

}
