package com.base.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
@Setter
public class Room extends AbstractEntity {


    @BsonProperty("basePrice")
    private double basePrice;
    @BsonProperty("roomNumber")
    private Integer roomNumber;
    @BsonProperty("roomCapacity")
    private Integer roomCapacity;

    @BsonProperty("possibleForRent")
    private String possibleForRent;

    @BsonCreator
    public Room(@BsonProperty("_id") UniqueId enitityId,
                @BsonProperty("basePrice") double basePrice,
                @BsonProperty("roomNumber") Integer roomNumber,
                @BsonProperty("roomCapacity") Integer roomCapacity,
                @BsonProperty("possibleForRent") String possibleForRent)

    {
        super(enitityId);
        this.basePrice = basePrice;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.possibleForRent = possibleForRent;
    }

    public Room(double basePrice, Integer roomNumber, Integer roomCapacity, String possibleForRent) {
        super(new UniqueId());
        this.basePrice = basePrice;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.possibleForRent = possibleForRent;
    }
}

