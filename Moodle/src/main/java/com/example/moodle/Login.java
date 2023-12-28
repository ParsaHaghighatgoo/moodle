package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.PrivateKey;

public class Login {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button login;

    private Button signupbutton;



    // This method is automatically called by the FXMLLoader when the FXML file is loaded.
    @FXML
    public void initialize() {
        login.setOnAction(this::handleLogin);
    }

    @FXML
    void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        for (User user : DataBase.users) {
            if (username.equals(user.username) && password.equals(user.password)) {
                System.out.println("hello");
                // Uncomment below code if you want to navigate to the AdminPage after successful login
                // navigateToAdminPage(user);
                return;
            }
        }
        System.out.println("no");
    }

    @FXML
    private void navigateToSignupPage(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("signup.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new stage
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("Signup Form");
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Error loading the signup page: " + e.getMessage());
        }
    }


}
