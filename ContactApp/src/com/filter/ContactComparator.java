package com.filter;

import com.contact.Contact;

import java.util.Comparator;

public class ContactComparator {

    public static Comparator<Contact> sortByName() {

        return Comparator.comparing(Contact::getName,
                String.CASE_INSENSITIVE_ORDER);
    }

    public static Comparator<Contact> sortByDate() {

        return Comparator.comparing(Contact::getCreatedAt);
    }

}