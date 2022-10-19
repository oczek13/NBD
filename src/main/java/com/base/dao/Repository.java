package com.base.dao;

public interface Repository <T>{
    void add(T obj);
    void remove(T obj);
    T get(Integer id);
//    T findByID(Integer id);
//    int quantity ();

}
