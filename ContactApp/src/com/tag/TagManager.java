package com.tag;

import com.contact.Contact;

import java.util.ArrayList;
import java.util.List;


// This is the Observer Pattern implementation.
public class TagManager {

    private List<TagObserver> observers = new ArrayList<>();

    public void addObserver(TagObserver observer) {
        observers.add(observer);
    }


    private void notifyObservers(Contact contact) {

        for (TagObserver observer : observers) {
            observer.onTagUpdated(contact);
        }
    }


    public void applyTags(Contact contact, List<String> tagNames) {

        for (String name : tagNames) {
            Tag tag = TagFactory.getTag(name);
            contact.addTag(tag);
        }

        notifyObservers(contact);
    }
}