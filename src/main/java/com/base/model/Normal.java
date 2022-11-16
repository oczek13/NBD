package com.base.model;

import lombok.Getter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
@BsonDiscriminator(key = "_clazz", value = "normal")
public class Normal extends Client {

    @BsonCreator
    public Normal(@BsonProperty("firstname") String firstName,
                   @BsonProperty("lastname") String lastName,
                   @BsonProperty("personalid") String personalID,
                   @BsonProperty("type") String type) {
        super(firstName, lastName, personalID, type);
    }

    @Override
    public String toString() {
        return "Normal";
    }
}
