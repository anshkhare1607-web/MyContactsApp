package com.controller;

import java.util.Scanner;

import com.service.UserService;
import com.service.ProfileService;
import com.session.SessionManager;


// menu controller
public class MenuController {

    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserService(); // services of user
    private ProfileService profileService = new ProfileService(); // profile services

    public void start() {

        while (true) {

            System.out.println("\n==== MyContactApp ====");
            System.out.println("1 Register");
            System.out.println("2 Login");
            System.out.println("3 Exit");
            System.out.print("Enter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    userService.registerUser();
                    break;

                case 2:
                    userService.loginMenu();
                    if (SessionManager.getInstance().getLoggedInUser() != null) {
                        loggedInMenu();
                    }
                    break;

                case 3:
                    return;
            }
        }
    }

    private void loggedInMenu() {

        while (true) {

            System.out.println("\n==== Profile Menu ====");
            System.out.println("1 View Profile");
            System.out.println("2 Update Profile");
            System.out.println("3 Change Password");
            System.out.println("4 Update Preferences");
            System.out.println("5 Logout");
            System.out.print("Enter your choice : ");


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
                    SessionManager.getInstance().logout();
                    return;
            }
        }
    }
    
}