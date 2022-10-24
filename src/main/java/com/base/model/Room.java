package com.base.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)

@NoArgsConstructor

@Entity
@Table(name = "Room")

public class Room extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomID", unique = true)
    private Integer roomID;

    @Column (name = "BasePrice")
    private double basePrice;

    @Column(name = "roomNumber", unique = true)
    private Integer roomNumber;

    @Column (name = "Capacity")
    private Integer roomCapacity;

    @Column (name = "isAvailable")
    private boolean isAvailable;

    @Override
    public String toString() {
        return "Room{" +
                "basePrice=" + basePrice +
                ", roomNumber=" + roomNumber +
                ", roomCapacity=" + roomCapacity +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public Room(double basePrice, Integer roomNumber, Integer roomCapacity, boolean isAvailable) {
        this.basePrice = basePrice;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.isAvailable = isAvailable;
    }
}
