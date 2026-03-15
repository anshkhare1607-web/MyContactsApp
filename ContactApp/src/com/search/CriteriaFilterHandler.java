package com.search;

import com.contact.Contact;
import java.util.List;
import java.util.stream.Collectors;

public class CriteriaFilterHandler extends FilterHandler {

    private SearchCriteria criteria;

    public CriteriaFilterHandler(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    //Override
    public List<Contact> apply(List<Contact> contacts) {

        List<Contact> filtered = contacts.stream()
                .filter(criteria::matches)
                .collect(Collectors.toList());

        if (next != null) {
            return next.apply(filtered);
        }

        return filtered;
    }
}