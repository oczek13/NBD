package com.base.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)

public class Room {
    private double basePrice;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomNumber;
    private Integer roomCapacity;
    private boolean isAvailable;

    public Room() {

    }

    @Override
    public String toString() {
        return "Room{" +
                "basePrice=" + basePrice +
                ", roomNumber=" + roomNumber +
                ", roomCapacity=" + roomCapacity +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
