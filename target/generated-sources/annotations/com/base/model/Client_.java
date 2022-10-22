package com.base.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ extends com.base.model.AbstractEntity_ {

	public static volatile SingularAttribute<Client, String> firstName;
	public static volatile SingularAttribute<Client, String> lastName;
	public static volatile SingularAttribute<Client, Boolean> isArchive;
	public static volatile SingularAttribute<Client, Integer> id;
	public static volatile SingularAttribute<Client, Integer> Personal_ID;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String IS_ARCHIVE = "isArchive";
	public static final String ID = "id";
	public static final String PERSONAL__ID = "Personal_ID";

}

