package com.base.dao;


import java.util.List;

public interface Repository <T, T_id>{
    void add(T obj);
    void remove(T obj);
    T findByID(T_id id);

    List<T> pobierzWszystkie();




}
