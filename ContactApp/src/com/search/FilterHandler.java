package com.search;

import com.contact.Contact;
import java.util.List;

// handling filteration
public abstract class FilterHandler {

    protected FilterHandler next;

    public void setNext(FilterHandler next) {
        this.next = next;
    }

    public abstract List<Contact> apply(List<Contact> contacts);

}