package com.repository;

import com.model.User;
import java.util.*;


// storing user data
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void saveUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }
}