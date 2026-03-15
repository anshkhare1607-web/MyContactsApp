package com.observer;

import com.contact.Contact;

public interface ContactDeletedObserver {

    void onContactDeleted(Contact contact);

}