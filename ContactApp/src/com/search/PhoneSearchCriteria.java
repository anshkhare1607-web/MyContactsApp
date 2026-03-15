package com.search;

import com.contact.Contact;
import com.contact.PhoneNumber;

// searching by phone number
public class PhoneSearchCriteria implements SearchCriteria {

    private String phone;

    public PhoneSearchCriteria(String phone) {
        this.phone = phone;
    }

    //Override
    public boolean matches(Contact contact) {

        for (PhoneNumber p : contact.getPhones()) {

            if (p.getNumber().contains(phone)) {
                return true;
            }
        }

        return false;
    }
}