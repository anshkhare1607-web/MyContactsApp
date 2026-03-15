package com.service;

import com.contact.*;
import com.repository.*;
import com.tag.*;
import java.util.*;
import java.util.stream.Collectors;

public class TagAssignmentService {

    private ContactRepository repository;
    private Scanner sc = new Scanner(System.in);
    private TagManager tagManager = new TagManager();

    public TagAssignmentService(ContactRepository repository) {

        this.repository = repository;

        tagManager.addObserver(new ConsoleTagObserver());
    }

    public void applyTagsToContact() {

        System.out.print("Enter Contact ID : ");
        String id = sc.nextLine();

        Optional<Contact> contactOpt = repository.findById(id);

        if (contactOpt.isEmpty()) {

            System.out.println("Contact not found");
            return;
        }

        Contact contact = contactOpt.get();

        System.out.print("Enter tags (comma separated) : ");

        String input = sc.nextLine();

        List<String> tags = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        tagManager.applyTags(contact, tags);

        System.out.println("Tags applied successfully");
    }
}