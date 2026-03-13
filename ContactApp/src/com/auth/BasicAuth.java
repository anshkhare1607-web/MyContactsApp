package com.auth;

import java.util.Optional;
import java.util.Scanner;

import com.model.User;
import com.repository.UserRepository;
import com.util.PasswordUtil;


// basic auth using username and password
public class BasicAuth implements AuthStrategy {

    private UserRepository repository;

    public BasicAuth(UserRepository repository) {
        this.repository = repository;
    }

    //Override
    public Optional<User> authenticate() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username : ");
        String username = sc.nextLine(); 

        System.out.print("Enter password : ");
        String password = sc.nextLine();

        String hash = PasswordUtil.hashPassword(password); // hashing password

        return repository.findByNameAndPassword(username, hash); // searching by name and password
    }
}