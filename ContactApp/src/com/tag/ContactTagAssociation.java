package com.tag;

import com.contact.Contact;

import java.util.HashSet;
import java.util.Set;

// This models the Contact ↔ Tag association.
public class ContactTagAssociation {

    private Contact contact;
    private Set<Tag> tags = new HashSet<>();

    public ContactTagAssociation(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {

        tags.add(tag);
        contact.addTag(tag);
    }

    public void removeTag(Tag tag) {

        tags.remove(tag);
        contact.removeTag(tag);
    }
}