package com.base.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import java.io.Serializable;


@Getter
@Setter
public abstract class AbstractEntity {
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
