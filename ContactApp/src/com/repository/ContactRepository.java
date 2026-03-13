package com.repository;

import java.util.*;
import com.contact.Contact;


// for storing contacts
public class ContactRepository {

    private List<Contact> contacts = new ArrayList<>();

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
    
    public Optional<Contact> findById(String id) {
        return contacts.stream()
                .filter(c -> c.getId().toString().equals(id))
                .findFirst();
    }
}