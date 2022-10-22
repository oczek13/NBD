package com.base.model;

public abstract class ClientType extends AbstractEntity{
    public abstract double getDiscout();

    public abstract String getTypeInfo();


    @Override
    public String toString() {
        return "";
    }
}
