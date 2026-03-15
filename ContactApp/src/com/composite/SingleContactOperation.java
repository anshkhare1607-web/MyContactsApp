package com.composite;

import com.contact.Contact;
import java.util.function.Consumer;

// for single operation
public class SingleContactOperation implements ContactComponent {

    private Contact contact;
    private Consumer<Contact> operation;

    public SingleContactOperation(Contact contact, Consumer<Contact> operation) {
        this.contact = contact;
        this.operation = operation;
    }

    //Override
    public void execute() {
        operation.accept(contact);
    }
}