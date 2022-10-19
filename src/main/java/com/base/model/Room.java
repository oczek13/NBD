package com.base.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)

@Entity
@Table(name = "Room")
@NoArgsConstructor
public class Room {

    @Column (name = "Base price")
    private double basePrice;

    @Column(name = "roomNumber", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomNumber;

    @Column (name = "Capacity")
    private Integer roomCapacity;

    @Column (name = "is Available")
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
}
