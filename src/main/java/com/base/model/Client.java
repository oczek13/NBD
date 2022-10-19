package com.base.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)

@Entity
@Table(name = "Client")
public class Client implements Serializable {

    @Column(name = "First Name")
    private String firstName;

    @Column (name = "Last Name")
    private String lastName;

    @Column(name = "personalID", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personalID;

    @Column (name = "Client type")
    private ClientType clientType;

    @OneToMany (mappedBy = "Rooms")
    private List<Rent> rents;

 @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalID='" + personalID + '\'' +
                '}';
    }
}
