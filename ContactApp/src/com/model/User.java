package com.model;


// base user class
public abstract class User {

    private String name;
    private String email;
    private String passwordHash;

    protected User(UserBuilder builder) { // creating object
        this.name = builder.name;
        this.email = builder.email;
        this.passwordHash = builder.passwordHash;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public static class UserBuilder {

        private String name;
        private String email;
        private String passwordHash;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;
            return this;
        }

        public User buildFreeUser() {
            return new FreeUser(this);
        }

        public User buildPremiumUser() {
            return new PremiumUser(this);
        }
    }
}