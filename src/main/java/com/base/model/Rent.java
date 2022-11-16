//package com.base.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import java.util.Date;
//import java.util.List;
//
//@Getter
//@Setter
//@Table(name = "Rent")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Access(AccessType.FIELD)
//@NoArgsConstructor
//@Entity
//
//public class Rent extends AbstractEntity {
//    @Id
//    @Column (name = "rentID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer rentID;
//
//    @ManyToOne
//   // @JoinColumn(name = "Client")
//    private Client client;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
//    @JoinTable(name = "rent_rooms",
//            joinColumns = {@JoinColumn(name = "rentID", referencedColumnName = "rentID")},
//            inverseJoinColumns = {@JoinColumn(name = "roomID", referencedColumnName = "roomID")})
//    @NotNull
//    private List<Room> rooms;
//
//    @Column (name = "beginTime")
//    private Date beginTime;
//
////    public Rent(Integer rentID, Client client, Room room, Date beginTime, Date endTime) throws Exception {
////        this.rentID = rentID;
////        this.client = client;
////        this.beginTime = beginTime;
////        if(endTime.getTime() - beginTime.getTime() < 0){
////            throw new Exception("Blad daty");
////        }
////    }
//
//    public Rent(List<Room> rooms, Client client) {
//        this.beginTime = new Date();
//        this.rooms = rooms;
//        this.client = client;
//    }
//
////    public Integer getRentDays(){
////        return Math.toIntExact(endTime.getTime() - beginTime.getTime());
////    }
//
////    public double getFinalRentCost(){
////      return getRentDays() * room.getBasePrice() * client.getClientType().getDiscount();
////    }
//}


package com.base.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
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



