package com.filter;

import com.contact.Contact;

import java.util.List;
import java.util.stream.Collectors;

// filtering using streams()
public class StreamFilterStrategy implements FilterStrategy {

    //Override
    public List<Contact> filter(List<Contact> contacts, ContactFilter filter) {

        return contacts.stream()
                .filter(filter::apply)
                .collect(Collectors.toList());
    }
}