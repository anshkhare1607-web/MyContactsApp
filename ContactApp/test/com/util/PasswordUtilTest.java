package com.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordUtilTest {

    @Test
    void testHashPassword() {

        String password = "mypassword"; 
        String hash = PasswordUtil.hashPassword(password);

        assertNotNull(hash);
        assertNotEquals(password, hash);
    }

    @Test
    void testSamePasswordSameHash() {

        String hash1 = PasswordUtil.hashPassword("abc123"); 
        String hash2 = PasswordUtil.hashPassword("abc123");

        assertEquals(hash1, hash2);
    }
}