package com.base.model;

public class Premium extends ClientType{
    @Override
    public double getDiscout() {
        return 0.7;
    }

    @Override
    public String getTypeInfo() {
        return "PREMIUM";
    }

    @Override
    public int getMaxDays() {
        return 14;
    }

    @Override
    public String toString() {
        return "Premium";
    }
}
