//MONGOS
package com.base.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;


@Getter
@Setter
public abstract class Client extends AbstractEntity {

    @BsonProperty("personalid")
    private String personalID;
    @BsonProperty("firstname")
    private String firstName;
    @BsonProperty("lastname")
    private String lastName;
    @BsonProperty("isarchived")
    private boolean isArchived;
    @BsonProperty("type")
    private String type;

    @BsonCreator
    public Client(@BsonProperty("_id") UniqueId enitityId,
                  @BsonProperty("firstname") String firstName,
                  @BsonProperty("lastname") String lastName,
                  @BsonProperty("personalid") String personalID,
                  @BsonProperty("type") String type)
    {
        super(enitityId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
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
}


