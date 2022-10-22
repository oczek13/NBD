package com.base.model;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rent.class)
public abstract class Rent_ extends com.base.model.AbstractEntity_ {

	public static volatile ListAttribute<Rent, Room> rooms;
	public static volatile SingularAttribute<Rent, Client> client;
	public static volatile SingularAttribute<Rent, Date> beginTime;
	public static volatile SingularAttribute<Rent, Integer> rentID;

	public static final String ROOMS = "rooms";
	public static final String CLIENT = "client";
	public static final String BEGIN_TIME = "beginTime";
	public static final String RENT_ID = "rentID";

}

