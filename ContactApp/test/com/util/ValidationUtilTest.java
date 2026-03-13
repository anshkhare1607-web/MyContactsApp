package com.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.exception.InvalidInputException;

class ValidationUtilTest {

    @Test
    void testValidEmail() {
        assertDoesNotThrow(() -> {
            EmailValidationUtil.validateEmail("test@gmail.com");
        });
    }

    @Test
    void testInvalidEmail() {

        assertThrows(InvalidInputException.class, () -> {
            EmailValidationUtil.validateEmail("invalid-email");
        });
    }
}