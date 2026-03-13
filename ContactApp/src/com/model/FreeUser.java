package com.model;


// class for free user
public class FreeUser extends User {

    public FreeUser(UserBuilder builder) {
        super(builder);
    }

    //Override
    public String toString() {
        return "FreeUser: " + getName() + " - " + getEmail();
    }
}