package com.base.model;

public abstract class ClientType extends AbstractEntity{
    public abstract double getDiscout();

    public abstract String getTypeInfo();

    public abstract int getMaxDays();

    @Override
    public String toString() {
        return "";
    }
}
