package com.model;


// class for premium user
public class PremiumUser extends User {

    public PremiumUser(UserBuilder builder) {
        super(builder);
    }

    //Override
    public String toString() {
        return "PremiumUser: " + getName() + " - " + getEmail();
    }
}