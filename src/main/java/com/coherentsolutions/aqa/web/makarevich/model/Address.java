package com.coherentsolutions.aqa.web.makarevich.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(firstName, address.firstName) && Objects.equals(lastName, address.lastName) && Objects.equals(streetAddress, address.streetAddress) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(state, address.state) && Objects.equals(zipCode, address.zipCode) && Objects.equals(phone, address.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, streetAddress, city, country, state, zipCode, phone);
    }
}
