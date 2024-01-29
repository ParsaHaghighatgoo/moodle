package com.example.moodle;

import java.security.SecureRandom;
import java.util.Base64;

public class Security {

    public static String generateToken() {
        // Generate a secure random byte array
        byte[] randomBytes = new byte[8]; // Adjust the size based on your requirements
        new SecureRandom().nextBytes(randomBytes);

        // Encode the byte array to Base64 for a more human-readable format
        return Base64.getEncoder().encodeToString(randomBytes);
    }

    public static void main(String[] args) {
        // Example of generating and printing a token
        String token = generateToken();
        System.out.println("Generated Token: " + token);
    }
}
