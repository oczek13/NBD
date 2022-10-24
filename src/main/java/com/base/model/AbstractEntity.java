package com.base.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@Access(AccessType.FIELD)
@Embeddable
public class AbstractEntity implements Serializable {
    @NotNull
    private UUID uniqueId = UUID.randomUUID();

    @Version
    private long version;
}