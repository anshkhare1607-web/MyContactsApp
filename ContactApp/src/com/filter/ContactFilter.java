package com.filter;

import com.contact.Contact;

// filtering contacts
public interface ContactFilter {

    boolean apply(Contact contact);

}