package com.service;

import java.time.LocalDateTime;
import java.util.*;
import com.contact.*;
import com.decorator.*;
import com.command.*;
import com.factory.ContactFactory;
import com.repository.ContactRepository;
import com.observer.*;
import com.composite.*;
import com.search.*;
import com.tag.*;
import com.filter.*;


// for managing contact service
public class ContactService {

    private ContactRepository repository = new ContactRepository();
    private Scanner sc = new Scanner(System.in);
    
    private CommandManager commandManager = new CommandManager();
    
    public ContactService() {

        repository.addObserver(new ContactDeletionLogger());

    }

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

        // factory for object creation
        Contact contact = ContactFactory.createContact(type, builder);

        repository.save(contact); // saving in repository

        System.out.println("Contact created successfully");
    }
    
    public void searchContacts() {

        System.out.println("Search by : ");
        System.out.println("1 Name");
        System.out.println("2 Phone");
        System.out.println("3 Email");
        System.out.println("4 Tag");
        System.out.print("Enter your choice : ");

        String choice = sc.nextLine();
        
        System.out.print("Enter the value : ");
        String value = sc.nextLine();

        SearchCriteria criteria = null;

        switch (choice) {

            case "1":
                criteria = new NameSearchCriteria(value);
                break;

            case "2":
                criteria = new PhoneSearchCriteria(value);
                break;

            case "3":
                criteria = new EmailSearchCriteria(value);
                break;

            case "4":
                criteria = new TagSearchCriteria(value);
                break;

            default:
                System.out.println("Invalid search option");
                return;
        }

        FilterHandler handler = new CriteriaFilterHandler(criteria);

        List<Contact> results =
                handler.apply(repository.getAllContacts());

        if (results.isEmpty()) {

            System.out.println("No contacts found.");
            return;
        }

        results.forEach(System.out::println);
    }
    
    // advanced filtering method
    public void advancedFilter() {

        CompositeContactFilter composite = new CompositeContactFilter();

        System.out.print("Apply tag filter? (yes/no) : ");
        String tagChoice = sc.nextLine();

        if (tagChoice.equalsIgnoreCase("yes")) {

            System.out.print("Enter tag : ");
            String tag = sc.nextLine();

            composite.addFilter(new TagFilter(tag));
        }

        System.out.println("Apply date filter? (yes/no) : ");
        String dateChoice = sc.nextLine(); 

        if (dateChoice.equalsIgnoreCase("yes")) {

            System.out.print("Enter days ago : ");
            int days = sc.nextInt();
            sc.nextLine();

            LocalDateTime date =
                    LocalDateTime.now().minusDays(days);

            composite.addFilter(new DateAddedFilter(date));
        }

        System.out.print("Apply frequently contacted filter? (yes/no) : ");
        String freqChoice = sc.nextLine();

        if (freqChoice.equalsIgnoreCase("yes")) {

            System.out.print("Enter minimum contact count : ");
            int count = sc.nextInt();
            sc.nextLine();

            composite.addFilter(
                    new FrequentlyContactedFilter(count)
            );
        }

        FilterStrategy strategy = new StreamFilterStrategy();

        List<Contact> results =
                strategy.filter(repository.getAllContacts(), composite);

        System.out.println("Sort results? ");
        System.out.println("1 Name");
        System.out.println("2 Date Added");

        int sortChoice = sc.nextInt();
        sc.nextLine();

        if (sortChoice == 1) {
            results.sort(ContactComparator.sortByName());
        } else {
            results.sort(ContactComparator.sortByDate());
        }

        if (results.isEmpty()) {

            System.out.println("No contacts found.");
            return;
        }

        results.forEach(System.out::println);
    }
    // edit contact method
    public void editContact() {

        System.out.print("Enter Contact ID : ");
        String id = sc.nextLine();

        Optional<Contact> contactOpt = repository.findById(id);

        if (contactOpt.isEmpty()) {
            System.out.println("Contact not found");
            return;
        }

        Contact contact = contactOpt.get();

        System.out.print("Enter new name : ");
        String newName = sc.nextLine();

        EditContactCommand command =
                new EditContactCommand(contact, newName);

        commandManager.executeCommand(command);

        System.out.println("Contact updated");
    }

    public void undoEdit() {
        commandManager.undo();
        System.out.println("Undo successful");
    }

    public void redoEdit() {
        commandManager.redo();
        System.out.println("Redo successful");
    }
    
    // deleting contact using contact id
    public void deleteContact() {

        try {

            System.out.print("Enter Contact ID : ");
            String id = sc.nextLine();

            Optional<Contact> contactOpt = repository.findById(id);

            if (contactOpt.isEmpty()) {

                System.out.println("Contact not found");
                return;
            }

            Contact contact = contactOpt.get();

            System.out.print("Are you sure you want to delete contact "
                    + contact.getName() + " ? (yes/no) : ");

            String confirm = sc.nextLine();

            if (!confirm.equalsIgnoreCase("yes")) {

                System.out.println("Deletion cancelled.");
                return;
            }

            repository.delete(contact);

            System.out.println("Contact deleted successfully");

        } catch (Exception e) {

            System.out.println("Error deleting contact : " + e.getMessage());

        }
    }
    
    // deleting in bulk
    public void bulkDeleteContacts() {

        System.out.println("Enter Contact IDs (comma separated) :");

        String input = sc.nextLine();

        List<String> ids = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        List<Contact> contacts = repository.findByIds(ids);

        CompositeContactOperation composite = new CompositeContactOperation();

        contacts.forEach(contact ->
                composite.add(
                        new SingleContactOperation(contact,
                                c -> repository.delete(c))
                )
        );

        composite.execute();

        System.out.println("Bulk delete completed");
    }

    // adding tags to multiple contacts
    public void bulkTagContacts() {

        System.out.print("Enter Contact IDs (comma separated) : ");
        String input = sc.nextLine();

        List<String> ids = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        System.out.print("Enter tag : ");

        String tagName = sc.nextLine();
        Tag tag = TagFactory.getTag(tagName); 

        List<Contact> contacts = repository.findByIds(ids);

        CompositeContactOperation composite = new CompositeContactOperation();

        contacts.forEach(contact ->
                composite.add(
                        new SingleContactOperation(contact,
                                c -> c.addTag(tag))
                )
        );

        composite.execute();

        System.out.println("Bulk tagging completed");
    }
    
    
    // displaying contact using Contact ID
    public void viewContactDetails() {

        System.out.print("Enter Contact ID :");
        String id = sc.nextLine();

        Optional<Contact> contactOptional = repository.findById(id);

        if (contactOptional.isEmpty()) {
            System.out.println("Contact not found");
            return;
        }

        Contact contact = contactOptional.get();

        // Increase frequency
        contact.incrementContactCount();

        ContactView view = new ContactView(contact);

        ContactDisplay display =
                new FormattedContactDisplay(new BasicContactDisplay());

        System.out.println("\n===== CONTACT DETAILS =====");
        System.out.println(display.display(view));
    }

    public void viewContacts() {

    	if(repository.getAllContacts().isEmpty()){
    		System.out.println("\nNo contacts found");
    		return;
    	}
        for (Contact contact : repository.getAllContacts()) {
            System.out.println(contact);
            System.out.println("-------------------");
        }
    }
}