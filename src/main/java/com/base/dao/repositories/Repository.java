package com.base.dao.repositories;

import java.util.List;

public interface Repository <T>{
    T add(T obj);
    void delete(T obj);
    T update (T obj);
    T getById(int id);
    public List<T> findAll();
}
