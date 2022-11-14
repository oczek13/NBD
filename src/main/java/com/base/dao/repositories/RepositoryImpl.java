//package com.base.dao.repositories;
//
//import com.base.model.AbstractEntity;
//import com.base.util.EntityManagerCreator;
//import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;
//import java.util.List;
//
//public abstract class RepositoryImpl <T extends AbstractEntity> implements Repository<T> {
//
//    protected EntityManager em;
//
//    public RepositoryImpl(EntityManager em){
//        this.em = em;
//    }
//    @Transactional
//    @Override
//    public T add(T obj) {
//        EntityManager manager = EntityManagerCreator.getEntityManager();
//        manager.getTransaction().begin();
//        manager.persist(obj);
//        manager.getTransaction().commit();
//        return obj;
//    }
//    @Transactional
//    @Override
//    public void delete(T obj) {
//        EntityManager manager = EntityManagerCreator.getEntityManager();
//        manager.getTransaction().begin();
//        obj = manager.merge(obj);
//        manager.remove(obj);
//        manager.getTransaction().commit();
//    }
//    @Transactional
//    @Override
//    public void update (T obj){
//        EntityManager manager = EntityManagerCreator.getEntityManager();
//        manager.getTransaction().begin();
//        manager.merge(obj);
//        manager.getTransaction().commit();
//    }
//
//    @Override
//    public T getById (int id) {
//        return null;
//    }
//
//    @Override
//    public List<T> findAll() {
//        return null;
//    }
//}
