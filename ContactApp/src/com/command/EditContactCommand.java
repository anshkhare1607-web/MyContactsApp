package com.command;

import com.contact.Contact;
import com.contact.ContactMemento;

public class EditContactCommand implements ContactCommand {

    private Contact contact;
    private ContactMemento backup;

    private String newName;

    public EditContactCommand(Contact contact, String newName) {
        this.contact = contact;
        this.newName = newName;
    }

    @Override
    public void execute() {
        backup = contact.saveState();
        contact.setName(newName);
    }

    @Override
    public void undo() {
        contact.restoreState(backup);
    }
}