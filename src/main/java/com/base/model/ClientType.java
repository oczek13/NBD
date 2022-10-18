package com.base.model;

import jakarta.persistence.MappedSuperclass;

public enum ClientType {
    NORMAL(1),
    PREMIUM(0.7);
    private double discount;

    ClientType(double discount) {
        this.discount = discount;
    }

    public double getDiscount(){
        return discount;
    }

}
