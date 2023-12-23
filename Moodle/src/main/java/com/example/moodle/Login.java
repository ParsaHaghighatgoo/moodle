package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    // This method handles the action event when the Login button is clicked.
    @FXML
    void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Here, you can implement your login logic, for example:
        if ("admin".equals(username) && "password".equals(password)) {
            System.out.println("Login successful!");
            // Navigate to the main application or dashboard.
        } else {
            System.out.println("Login failed. Please check your credentials.");
            // Show an error message to the user.
        }
    }

    // This method handles the action event when the Signup button is clicked.
    @FXML
    void handleSignup(ActionEvent event) {
        // Navigate to the signup page or perform other actions.
        System.out.println("Signup button clicked!");
    }
}

