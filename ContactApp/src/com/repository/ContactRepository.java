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
}