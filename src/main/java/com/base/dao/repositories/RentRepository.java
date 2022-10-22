package com.base.dao.repositories;

import com.base.model.Rent;
import jakarta.persistence.EntityManager;
import java.util.List;


public class RentRepository extends RepositoryImpl<Rent> {

    public RentRepository(EntityManager em) {
        super(em);
    }

    @Override
    public List<Rent> findAll() {
        return em.createQuery("Select rent from Rent rent", Rent.class).getResultList();
    }
}

