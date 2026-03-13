package com.controller;

import java.util.Scanner;

import com.service.UserService;


// menu controller
public class MenuController {

    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserService(); // user service instance

    public void start() {

        while (true) {

            System.out.println("\n==== MyContactApp ====");
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    userService.registerUser(); // register user
                    break;

                case 2:
                    userService.loginMenu(); // login user
                    break;

                case 3:
                    System.out.println("Log out");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}