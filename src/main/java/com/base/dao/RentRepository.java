package com.base.dao;

import com.base.model.Client;
import com.base.model.Rent;

import java.util.ArrayList;
import java.util.List;

public class RentRepository implements Repository<Rent>{
    private List<Rent> rents = new ArrayList<>();

    public Integer add(Rent obj){
        rents.add(obj);
        return null;
    }

    @Override
    public Rent findByID(Integer id) {
        if (rents.isEmpty()) return null;
        Rent auxiliaryRent = new Rent();
        for (Rent rent : rents) {
            if (rent.getRentID().equals(id)) {
                auxiliaryRent = rent;
            }
        }
        return auxiliaryRent;
    }

    @Override
    public void remove(Rent obj) {
        rents.remove(obj);
    }

    @Override
    public int quantity(){
        return rents.size();
    }
}
