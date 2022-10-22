package com.base.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name = "Rent")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)

@Entity

public class Rent extends AbstractEntity {
    @Id
    @Column (name = "rentID", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentID;

    @ManyToOne
   // @JoinColumn(name = "Client")
    private Client client;

    @OneToOne
    //@JoinColumn (name = "Room")
    private Room room;

//    @Column (name = "isArchive")
//    private boolean archive = false;

    @Column (name = "beginTime")
    private Date beginTime;

    @Column (name = "endTime")
    private Date endTime;

    public Rent() {
    }

    public Rent(Integer rentID, Client client, Room room, Date beginTime, Date endTime) throws Exception {
        this.rentID = rentID;
        this.client = client;
        this.room = room;
        this.beginTime = beginTime;
        this.endTime = endTime;
        if(endTime.getTime() - beginTime.getTime() < 0){
            throw new Exception("Blad daty");
        }
    }


    public Integer getRentDays(){
        return Math.toIntExact(endTime.getTime() - beginTime.getTime());
    }

    public double getFinalRentCost(){
      return getRentDays() * room.getBasePrice() * client.getClientType().getDiscount();
    }




}
