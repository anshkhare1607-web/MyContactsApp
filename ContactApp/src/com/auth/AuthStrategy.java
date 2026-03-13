package com.auth;

import java.util.Optional;
import com.model.User;

public interface AuthStrategy {

    Optional<User> authenticate();

}