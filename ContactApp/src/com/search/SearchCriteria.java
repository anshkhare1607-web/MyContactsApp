package com.search;

import com.contact.Contact;

// for searching contacts
public interface SearchCriteria {

    boolean matches(Contact contact);

}