package com.factory;

import com.model.User;


// user factory for creating objects
public class UserFactory {

    public static User createUser(String type, String name, String email, String passwordHash) {

        User.UserBuilder builder = new User.UserBuilder()
                .setName(name)
                .setEmail(email)
                .setPasswordHash(passwordHash);

        if (type.equalsIgnoreCase("premium")) {
            return builder.buildPremiumUser();
        } else {
            return builder.buildFreeUser();
        }
    }
}