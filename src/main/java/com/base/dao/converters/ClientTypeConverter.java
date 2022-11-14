//package com.base.dao.converters;
//
//import com.base.model.ClientType;
//import com.base.model.Normal;
//import com.base.model.Premium;
//import jakarta.persistence.AttributeConverter;
//
//public class ClientTypeConverter implements AttributeConverter<ClientType, String> {
//    @Override
//    public String convertToDatabaseColumn(ClientType clientType) {
//        return clientType.toString();
//    }
//
//    @Override
//    public ClientType convertToEntityAttribute(String s) {
//        {
//            return switch (s) {
//                case "Normal" -> new Normal();
//                case "Premium" -> new Premium();
//                default -> throw new IllegalArgumentException();
//            };
//        }
//    }
//}
