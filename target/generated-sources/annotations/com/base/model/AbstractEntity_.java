package com.base.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractEntity.class)
public abstract class AbstractEntity_ {

	public static volatile SingularAttribute<AbstractEntity, Long> version;
	public static volatile SingularAttribute<AbstractEntity, UUID> uniqueId;

	public static final String VERSION = "version";
	public static final String UNIQUE_ID = "uniqueId";

}

