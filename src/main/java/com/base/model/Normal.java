package com.base.model;

public class Normal extends ClientType{

    @Override
    public double getDiscout() {
        return 1.0;
    }

    @Override
    public String getTypeInfo() {
        return "NORMAL";
    }

    @Override
    public int getMaxDays() {
        return 7;
    }

    @Override
    public String toString() {
        return "Normal";
    }
}
