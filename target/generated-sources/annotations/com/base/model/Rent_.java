package com.base.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rent.class)
public abstract class Rent_ {

	public static volatile SingularAttribute<Rent, Client> client;
	public static volatile SingularAttribute<Rent, Boolean> archive;
	public static volatile SingularAttribute<Rent, Date> beginTime;
	public static volatile SingularAttribute<Rent, Date> endTime;
	public static volatile SingularAttribute<Rent, Room> room;
	public static volatile SingularAttribute<Rent, Integer> rentID;

	public static final String CLIENT = "client";
	public static final String ARCHIVE = "archive";
	public static final String BEGIN_TIME = "beginTime";
	public static final String END_TIME = "endTime";
	public static final String ROOM = "room";
	public static final String RENT_ID = "rentID";

}

