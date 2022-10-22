package com.base.dao.repositories;

import com.base.model.Client;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ClientRepository extends RepositoryImpl<Client> {

    public ClientRepository(EntityManager em) {
        super(em);
    }
    @Override
    public List<Client> findAll(){
        return em.createQuery("Select client from Client client", Client.class).getResultList();
    }

    @Override
    public Client getById(int id) {
        return em.find(Client.class, id);
    }
}

// Oczek13 zrobił syf na GitHubie :)