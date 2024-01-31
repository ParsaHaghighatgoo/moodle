package com.example.moodle;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class Encryption {
    // Number of iterations for PBKDF2
    private static final int ITERATIONS = 10000;
    // Key length for PBKDF2
    private static final int KEY_LENGTH = 256;
    // Salt length
    private static final int SALT_LENGTH = 32;

    public static void main(String[] args) {
        // User registration
        String password = "admin";
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);

        // Password verification during login
        String userInputPassword = "admin";
        boolean isValidPassword = verifyPassword(userInputPassword, hashedPassword);
        System.out.println("Password is valid: " + isValidPassword);
    }

    public static String hashPassword(String password) {
        try {
            // Generate a random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);

            // Hash the password with PBKDF2
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = skf.generateSecret(spec).getEncoded();

            // Combine salt and hash and encode to Base64
            byte[] combined = new byte[SALT_LENGTH + hash.length];
            System.arraycopy(salt, 0, combined, 0, SALT_LENGTH);
            System.arraycopy(hash, 0, combined, SALT_LENGTH, hash.length);

            return Base64.getEncoder().encodeToString(combined);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean verifyPassword(String userInputPassword, String storedHash) {
        try {
            // Decode stored hash from Base64
            byte[] combined = Base64.getDecoder().decode(storedHash);

            // Extract salt and hash from the combined value
            byte[] salt = Arrays.copyOfRange(combined, 0, SALT_LENGTH);
            byte[] storedHashBytes = Arrays.copyOfRange(combined, SALT_LENGTH, combined.length);

            // Hash the user input password with the stored salt
            PBEKeySpec spec = new PBEKeySpec(userInputPassword.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] userInputHash = skf.generateSecret(spec).getEncoded();

            // Compare the computed hash with the stored hash
            return Arrays.equals(userInputHash, storedHashBytes);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return false;
    }
}
