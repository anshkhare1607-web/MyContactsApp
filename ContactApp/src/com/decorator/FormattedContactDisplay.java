package com.decorator;

import com.contact.ContactView;
import com.contact.PhoneNumber;
import com.contact.EmailAddress;

// adding more details to the contacts
public class FormattedContactDisplay implements ContactDisplay {

    private ContactDisplay display;

    public FormattedContactDisplay(ContactDisplay display) {
        this.display = display;
    }

    //Override
    public String display(ContactView view) {

        StringBuilder phones = new StringBuilder();
        for (PhoneNumber p : view.getPhones()) {
            phones.append(p.getNumber()).append(" ");
        }

        StringBuilder emails = new StringBuilder();
        for (EmailAddress e : view.getEmails()) {
            emails.append(e.getEmail()).append(" ");
        }

        return display.display(view) +
                "\nContact ID: " + view.getId() +
                "\nPhones: " + phones +
                "\nEmails: " + emails +
                "\nCreated At: " + view.getCreatedAt();
    }
}