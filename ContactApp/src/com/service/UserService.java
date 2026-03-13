package com.service;

import java.util.Optional;
import java.util.Scanner;

import com.auth.*;
import com.factory.UserFactory;
import com.model.User;
import com.repository.UserRepository;
import com.session.SessionManager;
import com.util.*;


// managing user services
public class UserService {

    private Scanner sc = new Scanner(System.in);
    private UserRepository repository = new UserRepository();

    public void registerUser() {

        try {

            System.out.print("Enter name : ");
            String name = sc.nextLine(); 

            System.out.print("Enter email : ");
            String email = sc.nextLine();

            EmailValidationUtil.validateEmail(email); // validating email

            System.out.print("Enter password : ");
            String password = sc.nextLine();

            String hashedPassword = PasswordUtil.hashPassword(password); // storing hash of password

            System.out.print("User type (free/premium) : ");
            String type = sc.nextLine();

            User user = UserFactory.createUser(type, name, email, hashedPassword);

            repository.saveUser(user);

            System.out.println("User registered successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // handling login menu
    public void loginMenu() {

        System.out.println("\nLogin Method:");
        System.out.println("1. BasicAuth (username + password)");
        System.out.println("2. OAuth (email + password)");
        System.out.print("\nEnter your choice : ");

        int choice = sc.nextInt();
        sc.nextLine();

        AuthStrategy strategy;

        if (choice == 1) {
            strategy = new BasicAuth(repository);
        } else {
            strategy = new OAuthAuth(repository);
        }

        Optional<User> user = strategy.authenticate(); // for handling null values

        if (user.isPresent()) {

            SessionManager.getInstance().login(user.get());

            System.out.println("Login successful");
            System.out.println("Welcome " + user.get().getName());

        } else {

            System.out.println("Invalid credentials");
        }
    }
}