package com.auth;

import java.util.Optional;
import com.model.User;

// Authentication interface
public interface AuthStrategy {

    Optional<User> authenticate();

}