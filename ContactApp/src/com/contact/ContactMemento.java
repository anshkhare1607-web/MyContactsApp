package com.contact;

import java.util.ArrayList;
import java.util.List;

public class ContactMemento {

    private final String name;
    private final List<PhoneNumber> phones;
    private final List<EmailAddress> emails;

    public ContactMemento(Contact contact) {
        this.name = contact.getName();

        this.phones = new ArrayList<>();
        for (PhoneNumber p : contact.getPhones()) {
            this.phones.add(new PhoneNumber(p.getNumber()));
        }

        this.emails = new ArrayList<>();
        for (EmailAddress e : contact.getEmails()) {
            this.emails.add(new EmailAddress(e.getEmail()));
        }
    }

    public String getName() {
        return name;
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public List<EmailAddress> getEmails() {
        return emails;
    }
}