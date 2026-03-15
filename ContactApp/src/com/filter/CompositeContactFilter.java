package com.filter;

import com.contact.Contact;

import java.util.ArrayList;
import java.util.List;

// composite contact filtering
public class CompositeContactFilter implements ContactFilter {

    private List<ContactFilter> filters = new ArrayList<>();

    public void addFilter(ContactFilter filter) {
        filters.add(filter);
    }

    //Override
    public boolean apply(Contact contact) {

        for (ContactFilter filter : filters) {

            if (!filter.apply(contact)) {
                return false;
            }
        }

        return true;
    }
}