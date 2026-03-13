package com.model;

// base user class
public abstract class User {

    private String name;
    private String email;
    private String passwordHash;
    private String preference;

    protected User(UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.passwordHash = builder.passwordHash;
        this.preference = builder.preference;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getPreference() {
        return preference;
    }

    // Setters (for profile update)

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    // Builder Pattern for building object step by step
    public static class UserBuilder {

        private String name;
        private String email;
        private String passwordHash;
        private String preference;

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

        public UserBuilder setPreference(String preference) {
            this.preference = preference;
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