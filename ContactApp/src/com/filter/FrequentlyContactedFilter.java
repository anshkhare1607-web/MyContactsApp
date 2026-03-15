package com.filter;

import com.contact.Contact;

public class FrequentlyContactedFilter implements ContactFilter {

    private int threshold;

    public FrequentlyContactedFilter(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean apply(Contact contact) {

        return contact.getContactCount() >= threshold;
    }
}