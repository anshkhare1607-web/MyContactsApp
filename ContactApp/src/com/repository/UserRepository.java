package com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.model.User;

// user data storing
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void saveUser(User user) {
        users.add(user);
    }

    // finding user by its name and passwords
    public Optional<User> findByNameAndPassword(String name, String password) {

        return users.stream()
                .filter(u -> u.getName().equals(name) &&
                             u.getPasswordHash().equals(password))
                .findFirst();
    }

    // finding user by its email and password
    public Optional<User> findByEmailAndPassword(String email, String password) {

        return users.stream()
                .filter(u -> u.getEmail().equals(email) &&
                             u.getPasswordHash().equals(password))
                .findFirst();
    }
}