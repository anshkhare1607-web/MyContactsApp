package com.search;

import com.contact.Contact;
import java.util.ArrayList;
import java.util.List;

// searching via bulk criteria
public class CompositeSearchCriteria implements SearchCriteria {

    private List<SearchCriteria> criteriaList = new ArrayList<>();

    public void addCriteria(SearchCriteria criteria) {
        criteriaList.add(criteria);
    }

    //Override
    public boolean matches(Contact contact) {

        for (SearchCriteria criteria : criteriaList) {

            if (!criteria.matches(contact)) {
                return false;
            }
        }

        return true;
    }
}