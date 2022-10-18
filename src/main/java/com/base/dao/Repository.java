package com.base.dao;


import java.util.List;

public interface Repository <T>{
    void add(T obj);
    void remove(T obj);
    T findByID(Integer id);

}
