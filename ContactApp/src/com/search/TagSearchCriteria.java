package com.search;

import com.contact.Contact;

// searching by tag
public class TagSearchCriteria implements SearchCriteria {

    private String tag;

    public TagSearchCriteria(String tag) {
        this.tag = tag.toLowerCase();
    }

    //Override
    public boolean matches(Contact contact) {

        return contact.getTags()
                .stream()
                .anyMatch(t -> t.toLowerCase().contains(tag));
    }
}