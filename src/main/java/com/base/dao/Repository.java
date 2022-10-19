package com.base.dao;

public interface Repository <T>{
    Integer add(T obj);
    void remove(T obj);
    T findByID(Integer id);
    int quantity ();

}
