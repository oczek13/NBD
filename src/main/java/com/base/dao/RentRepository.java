package com.base.dao;

import com.base.model.Rent;

import java.util.ArrayList;
import java.util.List;

public class RentRepository implements Repository<Rent>{
    private List<Rent> rents = new ArrayList<>();

    public void add(Rent obj){
        rents.add(obj);
    }

    @Override
    public Rent findByID(Integer id) {
        if (rents.isEmpty()) return null;
        for (int i = 0; i < rents.size(); i++) {
            if (rents.get(i).getRentID() == id) {
                return rents.get(i);
            }
        }
        return null;
    }

    @Override
    public void remove(Rent obj) {
        if(rents.isEmpty()) return;
        else
            rents.remove(obj);
    }
}
