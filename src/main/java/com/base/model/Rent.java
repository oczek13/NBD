package com.base.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Rent extends AbstractEntity {

    @BsonProperty("begintime")
    private Date beginTime;
    @BsonProperty(value = "client", useDiscriminator = true)
    private Client client;
    @BsonProperty("rooms")
    @NotNull
    private List<Room> rooms;

    @BsonCreator
    public Rent(@BsonProperty("_id") UniqueId entityId,
                @BsonProperty("client") Client client,
                @BsonProperty("rooms")List<Room> rooms,
                @BsonProperty("begintime") Date begintime) {
        super(entityId);
        this.client = client;
        this.beginTime = new Date();
        this.rooms = rooms;
    }

    public Rent(Client client, List<Room> rooms) {
        super(new UniqueId());
        this.client = client;
        this.rooms = rooms;
        this.beginTime = new Date();
    }
}



