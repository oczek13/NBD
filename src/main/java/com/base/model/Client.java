package com.base.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Client")
@Access(AccessType.FIELD)
@NoArgsConstructor

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


// Testuje sobie GitHuba :)

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalID='" + personalID + '\'' +
                '}';
    }
}
