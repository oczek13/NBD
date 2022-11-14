package com.base.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.junit.platform.engine.UniqueId;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public abstract class AbstractEntity implements Serializable {
    @BsonProperty("_id")
    @BsonId
    protected UniqueId entityId;
    public AbstractEntity(UniqueId entityId) {
        this.entityId = entityId;
    }

//    @NotNull
//    private UUID uniqueId = UUID.randomUUID();
//
//    @Version
//    private long version;
}
