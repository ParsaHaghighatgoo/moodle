package com.example.moodle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Signup {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;

    @FXML
    private ComboBox<UserRole> combobox;

    @FXML
    private ComboBox<Gender> comboboxg;


    @FXML
    private Button signupButton;

    public void initialize() {
        combobox.setItems(FXCollections.observableArrayList(UserRole.STUDENT, UserRole.PROFESSOR));
        comboboxg.setItems(FXCollections.observableArrayList(Gender.MALE, Gender.FEMALE, Gender.OTHERS));
        signupButton.setOnAction(this::handleSignupButtonAction);
    }


    @FXML
    private void handleSignupButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String lastname = lastNameField.getText();
        String name = nameField.getText();
        String email = emailField.getText();
        UserRole userRole = combobox.getValue();
        Gender gender = comboboxg.getValue();

        if (email.isEmpty()) {
            email = "";
        }
        ArrayList<String> newlogindates = new ArrayList<>();
        User.addUser(2, username, password, name, lastname, 2, email, userRole, gender, newlogindates);
        System.out.println(":DDD");
        navigateToLoginPage(event);
    }

    @FXML
    private void navigateToLoginPage(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("login.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new stage
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("Welcome!");
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Error loading the signup page: " + e.getMessage());
        }
    }


}

