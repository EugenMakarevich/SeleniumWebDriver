package com.coherentsolutions.aqa.web.makarevich.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String country;
    private String state;
    private String zipCode;
    private String phone;

    @Override
    public String toString() {
        return "Address{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
