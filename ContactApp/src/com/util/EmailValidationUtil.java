package com.util;

import com.exception.InvalidInputException;

public class EmailValidationUtil {

	// test@xyz.com
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    public static void validateEmail(String email) {

        if (!email.matches(EMAIL_REGEX)) {
            throw new InvalidInputException("Invalid email format!");
        }
    }
}