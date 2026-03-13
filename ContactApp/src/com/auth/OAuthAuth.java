package com.auth;

import java.util.Optional; 
import java.util.Scanner;

import com.model.User;
import com.repository.UserRepository;
import com.util.PasswordUtil;


// open auth using email and password
public class OAuthAuth implements AuthStrategy {

    private UserRepository repository;

    public OAuthAuth(UserRepository repository) {
        this.repository = repository;
    }

    //Override
    public Optional<User> authenticate() { // optional for handling null values

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter email : ");
        String email = sc.nextLine();

        System.out.print("Enter password : ");
        String password = sc.nextLine();

        String hash = PasswordUtil.hashPassword(password); // hash of password

        return repository.findByEmailAndPassword(email, hash); // searching by email and hash
    }
}