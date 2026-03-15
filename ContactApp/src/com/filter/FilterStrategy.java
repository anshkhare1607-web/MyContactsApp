package com.filter;

import com.contact.Contact;

import java.util.List;

// filtering strategy
public interface FilterStrategy {

    List<Contact> filter(List<Contact> contacts, ContactFilter filter);

}