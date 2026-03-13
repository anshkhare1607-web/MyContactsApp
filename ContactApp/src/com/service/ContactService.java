package com.service;

import java.util.*;
import com.contact.*;
import com.factory.ContactFactory;
import com.repository.ContactRepository;

// for managing contact service
public class ContactService {

    private ContactRepository repository = new ContactRepository();
    private Scanner sc = new Scanner(System.in);

    public void createContact() {

    	// creating contact service
        System.out.print("Contact Type (person / organization) : ");
        String type = sc.nextLine();

        System.out.print("Enter contact name : ");
        String name = sc.nextLine();
 
        List<PhoneNumber> phones = new ArrayList<>();
        List<EmailAddress> emails = new ArrayList<>();

        System.out.print("How many phone numbers? : ");
        int phoneCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < phoneCount; i++) {
            System.out.print("Enter phone : ");
            phones.add(new PhoneNumber(sc.nextLine()));
        }

        System.out.print("How many emails? : ");
        int emailCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < emailCount; i++) {
            System.out.print("Enter email : ");
            emails.add(new EmailAddress(sc.nextLine()));
        }

        // calling builder for building contact
        Contact.ContactBuilder builder = new Contact.ContactBuilder()
                .setName(name)
                .setPhones(phones)
                .setEmails(emails);

        // factory for oject creation
        Contact contact = ContactFactory.createContact(type, builder);

        repository.save(contact); // saving in repository

        System.out.println("Contact created successfully");
    }

    public void viewContacts() {

        for (Contact contact : repository.getAllContacts()) {
            System.out.println(contact);
            System.out.println("-------------------");
        }
    }
}