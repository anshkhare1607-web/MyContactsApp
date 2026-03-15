package com.filter;

import com.contact.Contact;

import java.time.LocalDateTime;

// filtering using date added
public class DateAddedFilter implements ContactFilter {

    private LocalDateTime date;

    public DateAddedFilter(LocalDateTime date) {
        this.date = date;
    }

    //Override
    public boolean apply(Contact contact) {

        return contact.getCreatedAt().isAfter(date);
    }
}