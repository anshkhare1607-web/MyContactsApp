package com.service;

import com.factory.UserFactory;
import com.model.User;
import com.repository.*;
import com.util.*;

import java.util.Scanner;


// for user service ->  taking user data for registration
public class UserService {

    private Scanner sc = new Scanner(System.in);
    private UserRepository repository = new UserRepository();

    public void registerUser() {

        try {

            System.out.print("Enter name: ");
            String name = sc.nextLine(); 

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            EmailValidationUtil.validateEmail(email);

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            String hashedPassword = PasswordUtil.hashPassword(password);

            System.out.print("User type (free/premium): ");
            String type = sc.nextLine(); 

            // user factory for creating user
            User user = UserFactory.createUser(type, name, email, hashedPassword); 

            repository.saveUser(user);

            System.out.println("User registered successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}