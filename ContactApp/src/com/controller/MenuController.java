package com.controller;

import java.util.Scanner;

import com.service.*;
import com.session.SessionManager;


// class for menu control
public class MenuController {

    private Scanner sc = new Scanner(System.in);

    private UserService userService = new UserService();
    private ProfileService profileService = new ProfileService();
    private ContactService contactService = new ContactService();

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
            System.out.println("8 Logout");
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
                    SessionManager.getInstance().logout();
                    System.out.println("Logged out successfully");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}