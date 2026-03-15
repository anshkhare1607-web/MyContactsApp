package com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.contact.Contact;
import com.observer.ContactDeletedObserver;


// for storing contact details
public class ContactRepository {

    private List<Contact> contacts = new ArrayList<>();
    private List<ContactDeletedObserver> observers = new ArrayList<>();

    public void save(Contact contact) {
        contacts.add(contact);
    }

    // fetching all contacts
    public List<Contact> getAllContacts() {

        List<Contact> active = new ArrayList<>();

        for (Contact c : contacts) {
            if (!c.isDeleted()) {
                active.add(c);
            }
        }

        return active;
    }
    
    // finding in bulk
    public List<Contact> findByIds(List<String> ids) {

        return contacts.stream()
                .filter(c -> ids.contains(c.getId().toString()))
                .toList();
    }

    // finding one id
    public Optional<Contact> findById(String id) {

        return contacts.stream()
                .filter(c -> c.getId().toString().equals(id))
                .findFirst();
    }

    // deleting contact
    public void delete(Contact contact) {

        contact.markDeleted();

        notifyObservers(contact);
    }

    public void addObserver(ContactDeletedObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Contact contact) {

        for (ContactDeletedObserver observer : observers) {
            observer.onContactDeleted(contact);
        }
    }
}