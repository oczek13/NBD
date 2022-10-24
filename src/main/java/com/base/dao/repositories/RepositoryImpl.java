package com.base.dao.repositories;

import com.base.dao.repositories.Repository;
import com.base.model.AbstractEntity;
import com.base.util.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;

import java.util.List;

public abstract class RepositoryImpl <T extends AbstractEntity> implements Repository<T> {

    protected EntityManager em;

    public RepositoryImpl(EntityManager em){
        this.em = em;
    }
    @Transactional
    @Override
    public T add(T obj) {
        EntityManager manager = EntityManagerCreator.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(obj);
        manager.getTransaction().commit();
        return obj;
    }
    @Transactional
    @Override
    public void delete(T obj) {

//        EntityTransaction entityTransaction = em.getTransaction();
//        entityTransaction.begin();
//        em.remove(obj);
//        entityTransaction.commit();
        EntityManager manager = EntityManagerCreator.getEntityManager();
        manager.getTransaction().begin();
        obj = manager.merge(obj);
        manager.remove(obj);
        manager.getTransaction().commit();
    }
    @Transactional
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
