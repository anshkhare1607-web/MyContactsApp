package com.decorator;

import com.contact.ContactView;

// decorator for displaying contacts
public interface ContactDisplay {

    String display(ContactView view);

}