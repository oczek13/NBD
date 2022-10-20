package com.base.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Table(name = "Client")

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)

@Entity

public class Client implements Serializable {

    @Column(name = "FirstName")
    private String firstName;

    @Column (name = "LastName")
    private String lastName;

    @Column(name = "personalID", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personalID;

    @Column (name = "ClientType")
    private ClientType clientType;

//    @OneToMany (mappedBy = "client")
//    private List<Rent> rents;

 @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalID='" + personalID + '\'' +
                '}';
    }

    public Client(String firstName, String lastName, ClientType clientType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientType = clientType;
    }
}
