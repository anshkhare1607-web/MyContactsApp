package com.contact;

import java.time.LocalDateTime;
import java.util.*;

import com.tag.Tag;

// Base class for Contact structure
public abstract class Contact {

    protected UUID id;                     // unique contact ID
    protected String name;
    protected List<PhoneNumber> phones;   // multiple phone numbers
    protected List<EmailAddress> emails;  // multiple emails
    protected LocalDateTime createdAt;    // creation timestamp

    private boolean deleted;              // soft delete flag
    private int contactCount = 0;         // frequency counter

    // many-to-many relationship with tags
    private Set<Tag> tags = new HashSet<>();


    // Builder constructor
    protected Contact(ContactBuilder builder) {

        this.id = UUID.randomUUID();
        this.name = builder.name;

        this.phones = new ArrayList<>(builder.phones);
        this.emails = new ArrayList<>(builder.emails);

        this.createdAt = LocalDateTime.now();
        this.deleted = false;
    }

    // Copy constructor (deep copy)
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
        this.deleted = other.deleted;
        this.contactCount = other.contactCount;

        this.tags = new HashSet<>(other.tags);
    }


    // Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PhoneNumber> getPhones() {
        return new ArrayList<>(phones); // defensive copy
    }

    public List<EmailAddress> getEmails() {
        return new ArrayList<>(emails);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public int getContactCount() {
        return contactCount;
    }

    public Set<Tag> getTags() {
        return new HashSet<>(tags);
    }


    // Lifecycle methods
    public void markDeleted() {
        this.deleted = true;
    }


    // Frequency tracking
    public void incrementContactCount() {
        contactCount++;
    }

    public void resetContactCount() {
        contactCount = 0;
    }

    // Setters with validation
    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public void setPhones(List<PhoneNumber> phones) {
        this.phones = new ArrayList<>(phones);
    }

    public void setEmails(List<EmailAddress> emails) {
        this.emails = new ArrayList<>(emails);
    }

    // Tag management
    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }


    // Memento Pattern support
    public ContactMemento saveState() {
        return new ContactMemento(this);
    }

    public void restoreState(ContactMemento memento) {

        this.name = memento.getName();
        this.phones = new ArrayList<>(memento.getPhones());
        this.emails = new ArrayList<>(memento.getEmails());
    }


    // Builder Pattern
    public static class ContactBuilder {

        protected String name;
        protected List<PhoneNumber> phones = new ArrayList<>();
        protected List<EmailAddress> emails = new ArrayList<>();

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