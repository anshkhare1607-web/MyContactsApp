package com.controller;

import java.util.Scanner;

import com.repository.ContactRepository;
import com.service.*;
import com.session.SessionManager;


// class for menu control
public class MenuController {

	private Scanner sc = new Scanner(System.in);

	private UserService userService = new UserService();
	private ProfileService profileService = new ProfileService();
	private ContactService contactService = new ContactService();
	private ContactRepository contactRepository = new ContactRepository();
	private TagAssignmentService tagAssignmentService = new TagAssignmentService(contactRepository);

	public void start() {

		while (true) {

			System.out.println("\n==== MyContactApp ===="); 
			System.out.println("1 Register User");
			System.out.println("2 Login");
			System.out.println("3 Exit");
			System.out.print("Enter choice : ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				userService.registerUser(); // register user
				break;

			case 2:
				userService.loginMenu(); // login user

				if (SessionManager.getInstance().getLoggedInUser() != null) {
					loggedInMenu(); // if already logged in user
				}

				break;

			case 3:
				System.out.println("Exiting application"); // logout
				return;

			default:
				System.out.println("Invalid choice");
			}
		}
	}

	private void loggedInMenu() {

		// after logging in, services available
		while (true) {

			System.out.println("\n==== USER MENU ====");
			System.out.println("1 View Profile");
			System.out.println("2 Update Profile");
			System.out.println("3 Change Password");
			System.out.println("4 Update Preferences");
			System.out.println("5 Create Contact");
			System.out.println("6 View Contacts");
			System.out.println("7 View Contact Details");
			System.out.println("8 Search Contacts");
			System.out.println("9 Edit Contact");
			System.out.println("10 Delete Contact");
			System.out.println("11 Bulk Delete Contacts");
			System.out.println("12 Bulk Tag Contacts");
			System.out.println("13 Undo Edit");
			System.out.println("14 Redo Edit");
			System.out.println("15 Apply Tags to Contact");
			System.out.println("16 Logout");
			System.out.print("Enter choice : ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				profileService.viewProfile();
				break;

			case 2:
				profileService.updateProfile();
				break;

			case 3:
				profileService.changePassword();
				break;

			case 4:
				profileService.updatePreference();
				break;

			case 5:
				contactService.createContact(); 
				break;

			case 6:
				contactService.viewContacts();
				break;

			case 7:
				contactService.viewContactDetails();
				break;

			case 8:
				contactService.searchContacts(); // search using different criterias
				break;

			case 9:
				contactService.editContact(); // edit contact
				break;

			case 10:
				contactService.deleteContact(); // delete contact
				break;

			case 11:
				contactService.bulkDeleteContacts(); // delete in bulk
				break;

			case 12:
				contactService.bulkTagContacts(); // adding tags in bulk
				break;

			case 13:
				contactService.undoEdit(); // undo changes
				break;

			case 14:
				contactService.redoEdit(); // redo changes
				break;
				
			case 15:
				tagAssignmentService.applyTagsToContact();
				break;
				
			case 16:
				SessionManager.getInstance().logout();
				System.out.println("Logged out successfully");
				return;

			default:
				System.out.println("Invalid choice");
			}
		}
	}
}