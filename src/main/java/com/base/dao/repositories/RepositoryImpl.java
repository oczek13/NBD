package com.base.dao.repositories;

import com.base.dao.repositories.Repository;
import com.base.model.AbstractEntity;
import com.base.util.EntityManagerCreator;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RepositoryImpl <T extends AbstractEntity> implements Repository<T> {

    protected EntityManager em;

    public RepositoryImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public T add(T obj) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(obj);
        manager.getTransaction().commit();
        return obj;
    }

    @Override
    public void remove(T obj) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        manager.getTransaction().begin();
        manager.remove(obj);
        manager.getTransaction().commit();
    }

    @Override
    public T update (T obj){
        EntityManager manager = EntityManagerCreator.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(obj);
        manager.getTransaction().commit();
        return obj;
    }

    @Override
    public T getById (int id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
