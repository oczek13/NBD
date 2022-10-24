package com.base.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Room.class)
public abstract class Room_ extends com.base.model.AbstractEntity_ {

	public static volatile SingularAttribute<Room, Boolean> isAvailable;
	public static volatile SingularAttribute<Room, Integer> roomNumber;
	public static volatile SingularAttribute<Room, Integer> roomCapacity;
	public static volatile SingularAttribute<Room, Integer> roomID;
	public static volatile SingularAttribute<Room, Double> basePrice;

	public static final String IS_AVAILABLE = "isAvailable";
	public static final String ROOM_NUMBER = "roomNumber";
	public static final String ROOM_CAPACITY = "roomCapacity";
	public static final String ROOM_ID = "roomID";
	public static final String BASE_PRICE = "basePrice";

}

