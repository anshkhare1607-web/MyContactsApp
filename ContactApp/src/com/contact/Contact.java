package com.contact;

import java.time.*;
import java.util.*;


// class for Contact structure
public abstract class Contact {

    protected UUID id; // for storing with unique ID
    protected String name;
    protected List<PhoneNumber> phones; // storing more than 1 phone numbers
    protected List<EmailAddress> emails; // multiple emails storage
    protected LocalDateTime createdAt; // time at which the contact is created

    protected Contact(ContactBuilder builder) {
        this.id = UUID.randomUUID();
        this.name = builder.name;
        this.phones = builder.phones;
        this.emails = builder.emails;
        this.createdAt = LocalDateTime.now();
    }

    
    // getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public List<EmailAddress> getEmails() {
        return emails;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // building contact step by step
    public static class ContactBuilder {

        protected String name;
        protected List<PhoneNumber> phones;
        protected List<EmailAddress> emails;

        public ContactBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ContactBuilder setPhones(List<PhoneNumber> phones) {
            this.phones = phones;
            return this;
        }

        public ContactBuilder setEmails(List<EmailAddress> emails) {
            this.emails = emails;
            return this;
        }
    }
}