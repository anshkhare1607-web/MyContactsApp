package com.service;

import com.contact.Contact;
import com.repository.ContactRepository;
import com.tag.Tag;
import com.tag.TagFactory;

import java.util.Optional;
import java.util.Scanner;

public class TagService {

    private ContactRepository repository;
    private Scanner scanner = new Scanner(System.in);

    public TagService(ContactRepository repository) {
        this.repository = repository;
    }

    public void addTagToContact() {

        System.out.print("Enter Contact ID : ");
        String id = scanner.nextLine();

        Optional<Contact> contactOpt = repository.findById(id);

        if (contactOpt.isEmpty()) {

            System.out.println("Contact not found");
            return;
        }

        Contact contact = contactOpt.get();

        System.out.print("Enter tag name: ");
        String tagName = scanner.nextLine();

        Tag tag = TagFactory.getTag(tagName);

        contact.addTag(tag);

        System.out.println("Tag added successfully.");
    }

    public void removeTagFromContact() {

        System.out.print("Enter Contact ID: ");
        String id = scanner.nextLine();

        Optional<Contact> contactOpt = repository.findById(id);

        if (contactOpt.isEmpty()) {

            System.out.println("Contact not found");
            return;
        }

        Contact contact = contactOpt.get();

        System.out.print("Enter tag to remove : ");
        String tagName = scanner.nextLine();

        Tag tag = TagFactory.getTag(tagName);

        contact.removeTag(tag);

        System.out.println("Tag removed successfully");
    }
}