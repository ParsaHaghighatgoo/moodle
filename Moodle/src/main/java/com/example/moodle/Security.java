package com.example.moodle;

import java.util.UUID;
import java.security.SecureRandom;
import java.util.Base64;

public class Security {
    public static String generateToken() {
        // Generate a random UUID
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static void main(String[] args) {
        // Example of generating and printing a token
        String token = generateToken();
        System.out.println("Generated Token: " + token);
    }
}