package com.controller;

import com.service.UserService;
import java.util.Scanner;


// menu controller 
public class MenuController {

    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserService(); // User service

    public void start() {
        while (true) {

            System.out.println("\n==== MyContactApp ====");
            System.out.println("1. Register User");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    userService.registerUser(); // register user
                    break;

                case 2: // exiting application
                    System.out.println("Exiting application"); 
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}