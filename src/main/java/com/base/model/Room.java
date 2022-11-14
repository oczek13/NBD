//package com.base.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Access(AccessType.FIELD)
//
//@NoArgsConstructor
//
//@Entity
//@Table(name = "Room")
//
//public class Room extends AbstractEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "roomID")
//    private Integer roomID;
//
//    @Column (name = "BasePrice")
//    private double basePrice;
//
//    @Column(name = "roomNumber")
//    private Integer roomNumber;
//
//    @Column (name = "Capacity")
//    private Integer roomCapacity;
//
//    @Column (name = "isAvailable")
//    private boolean isAvailable;
//
//    @Override
//    public String toString() {
//        return "Room{" +
//                "basePrice=" + basePrice +
//                ", roomNumber=" + roomNumber +
//                ", roomCapacity=" + roomCapacity +
//                ", isAvailable=" + isAvailable +
//                '}';
//    }
//
//    public Room(double basePrice, Integer roomNumber, Integer roomCapacity, boolean isAvailable) {
//        this.basePrice = basePrice;
//        this.roomNumber = roomNumber;
//        this.roomCapacity = roomCapacity;
//        this.isAvailable = isAvailable;
//    }
//}


package com.base.model;

import com.base.model.UniqueId;
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
    @BsonProperty("isAvailable")
    private boolean isAvailable;

    @BsonCreator
    public Room(@BsonProperty("_id") UniqueId enitityId,
                @BsonProperty("basePrice") double basePrice,
                @BsonProperty("roomNumber") Integer roomNumber,
                @BsonProperty("roomCapacity") Integer roomCapacity,
                @BsonProperty("isAvailable") boolean isAvailable)
    {
        super(enitityId);
        this.basePrice = basePrice;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.isAvailable = isAvailable;
    }

    public Room(double basePrice, Integer roomNumber, Integer roomCapacity) {
        super(new UniqueId());
        this.basePrice = basePrice;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
    }
}

