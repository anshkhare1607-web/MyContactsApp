package com.observer;

import com.contact.Contact;

// for deleting contacts
public interface ContactDeletedObserver {

    void onContactDeleted(Contact contact);

}