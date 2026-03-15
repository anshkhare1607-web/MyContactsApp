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
    
    private boolean deleted;

    protected Contact(ContactBuilder builder) {
        this.id = UUID.randomUUID();
        this.name = builder.name;
        this.phones = builder.phones;
        this.emails = builder.emails;
        this.createdAt = LocalDateTime.now();
        this.deleted = false;

    }

 // Copy constructor
    public Contact(Contact other) {
        this.id = other.id;
        this.name = other.name;

        this.phones = new ArrayList<>();
        for (PhoneNumber p : other.phones) {
            this.phones.add(new PhoneNumber(p.getNumber()));
        }

        this.emails = new ArrayList<>();
        for (EmailAddress e : other.emails) {
            this.emails.add(new EmailAddress(e.getEmail()));
        }

        this.createdAt = other.createdAt;
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
    
    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }
    
    // setters
    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");

        this.name = name;
    }

    public void setPhones(List<PhoneNumber> phones) {
        this.phones = new ArrayList<>(phones);
    }

    public void setEmails(List<EmailAddress> emails) {
        this.emails = new ArrayList<>(emails);
    }

    public ContactMemento saveState() {
        return new ContactMemento(this);
    }

    public void restoreState(ContactMemento memento) {
        this.name = memento.getName();
        this.phones = new ArrayList<>(memento.getPhones());
        this.emails = new ArrayList<>(memento.getEmails());
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