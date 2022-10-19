package com.base.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public interface EntityManagerFactory {
    jakarta.persistence.EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.baeldung.movie_catalog");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
