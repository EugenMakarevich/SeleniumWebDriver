package com.coherentsolutions.aqa.web.makarevich.services;

import com.coherentsolutions.aqa.web.makarevich.model.User;
import com.github.javafaker.Faker;

public class UserService {
    public User createFakeUser() {
        User user = new User();
        Faker faker = new Faker();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password(8, 16, true, true)); // password with length between 8 & 16, uppercase & special chars are included
        return user;
    }
}
