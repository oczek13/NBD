//package com.base.model;
//
//import com.base.dao.converters.ClientTypeConverter;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import java.io.Serializable;
//
//@Table(name = "Client")
//
//@Getter
//@Setter
//
//@AllArgsConstructor
//@NoArgsConstructor
//
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Access(AccessType.FIELD)
//
//@Entity
//@Embeddable
//public class Client extends AbstractEntity {
//
//    @Id
//    @Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @NotEmpty
//    @Column(name = "Personal_ID")
//    private Integer Personal_ID;
//
//    @NotEmpty
//    @Column(name = "First_Name")
//    private String firstName;
//
//    @NotEmpty
//    @Column (name = "Last_Name")
//    private String lastName;
//
//    @Convert(converter = ClientTypeConverter.class)
//    private ClientType clientType;
//
//    @NotEmpty
//    @Column
//    boolean isArchive = false;
//
//    public Client(final String firstName, final String lastName, final Integer Personal_ID, final ClientType clientType) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.Personal_ID = Personal_ID;
//        this.clientType = clientType;
//    }
//}

                                      //MONGOS
package com.base.model;


import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;


@Getter
@Setter
@BsonDiscriminator(key = "_clazz")
public abstract class Client extends AbstractEntity {

    @BsonProperty("personalid")
    private String personalID;
    @BsonProperty("firstname")
    private String firstName;
    @BsonProperty("lastname")
    private String lastName;
    @BsonProperty("age")
    private Integer age;
    @BsonProperty("isarchived")
    private boolean isArchived;
    @BsonProperty("type")
    private String type;


    @BsonCreator
    public Client(@BsonProperty("_id") UniqueId enitityId,
                  @BsonProperty("firstname") String firstName,
                  @BsonProperty("lastname") String lastName,
                  @BsonProperty("personalid") String personalID,
                  @BsonProperty("isarchived") boolean isArchived,
                  @BsonProperty("type") String type)
    {
        super(enitityId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
        this.isArchived = isArchived;
        this.type = type;
    }

    public Client(String firstName, String lastName,  String personalID, String type) {
        super(new UniqueId());
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
        this.isArchived = false;
        this.type = type;
    }

    public abstract double getDiscount();


    public abstract String getTypeInfo();
}


