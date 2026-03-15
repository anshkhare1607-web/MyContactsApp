package com.search;

import com.contact.Contact;
import java.util.regex.Pattern;

// searching by name
public class NameSearchCriteria implements SearchCriteria {

    private Pattern pattern;

    public NameSearchCriteria(String name) {
        this.pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
    }

    //Override
    public boolean matches(Contact contact) {

        if (contact.getName() == null) {
            return false;
        }

        return pattern.matcher(contact.getName()).find();
    }
}