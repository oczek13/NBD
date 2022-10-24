package com.base.model;

import com.base.dao.converters.ClientTypeConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
@Embeddable
public class Client extends AbstractEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "Personal_ID")
    private Integer Personal_ID;

    @NotEmpty
    @Column(name = "First_Name")
    private String firstName;

    @NotEmpty
    @Column (name = "Last_Name")
    private String lastName;

    @Convert(converter = ClientTypeConverter.class)
    private ClientType clientType;

    @NotEmpty
    @Column
    boolean isArchive = false;

    public Client(final String firstName, final String lastName, final Integer Personal_ID, final ClientType clientType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Personal_ID = Personal_ID;
        this.clientType = clientType;
    }
}
