package com.search;

import com.contact.Contact;
import com.contact.EmailAddress;

// search by email
public class EmailSearchCriteria implements SearchCriteria {

    private String email;

    public EmailSearchCriteria(String email) {
        this.email = email.toLowerCase();
    }

    //Override
    public boolean matches(Contact contact) {

        for (EmailAddress e : contact.getEmails()) {

            if (e.getEmail().toLowerCase().contains(email)) {
                return true;
            }
        }

        return false;
    }
}