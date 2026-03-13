package com.decorator;

import com.contact.ContactView;

public class BasicContactDisplay implements ContactDisplay {

    //Override
    public String display(ContactView view) {

        return "Name: " + view.getName();
    }
}