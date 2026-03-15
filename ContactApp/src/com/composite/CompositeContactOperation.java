package com.composite;

import java.util.ArrayList;
import java.util.List;

// operations for multiple contacts
public class CompositeContactOperation implements ContactComponent {

    private List<ContactComponent> components = new ArrayList<>();

    public void add(ContactComponent component) {
        components.add(component);
    }

    //Override
    public void execute() {

        for (ContactComponent component : components) {
            component.execute();
        }
    }
}