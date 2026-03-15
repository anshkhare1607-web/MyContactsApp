package com.tag;

import com.contact.Contact;

public class ConsoleTagObserver implements TagObserver {

    //Override
    public void onTagUpdated(Contact contact) {

        System.out.println("UI Update → Tags changed for contact: "
                + contact.getName());
    }
}