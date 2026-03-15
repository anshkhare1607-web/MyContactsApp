package com.observer;

import com.contact.Contact;

public class ContactDeletionLogger implements ContactDeletedObserver {

    //Override
    public void onContactDeleted(Contact contact) {

        System.out.println("LOG: Contact deleted -> " + contact.getName());

    }
}