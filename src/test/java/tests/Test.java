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
            Client client = new Client("Adam", "Malysz", 21, ClientType.NORMAL);
            e.getTransaction().begin();
            e.persist(client);
            e.getTransaction().commit();
        }

    }

}
