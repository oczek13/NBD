//package com.base.model;
//
//public class Normal extends ClientType{
//
//    @Override
//    public double getDiscout() {
//        return 1.0;
//    }
//
//    @Override
//    public String getTypeInfo() {
//        return "NORMAL";
//    }
//
//
//    @Override
//    public String toString() {
//        return "Normal";
//    }
//}



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
                   @BsonProperty("personalid") String personalID) {
        super(firstName, lastName, personalID);
    }


    public double getDiscount() {
        return 1.0;
    }

    @Override
    public String getTypeInfo() {
        return "NORMAL";
    }

    @Override
    public String toString() {
        return "Normal";
    }
}
