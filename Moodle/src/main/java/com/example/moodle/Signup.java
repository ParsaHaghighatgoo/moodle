package com.example.moodle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    @FXML
    private Button Back;

    public void initialize() {

        comboboxg.setItems(FXCollections.observableArrayList(Gender.MALE, Gender.FEMALE, Gender.OTHERS));
        signupButton.setOnAction(this::handleSignupButtonAction);
    }


    @FXML
    void navigateToLogin(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("Login.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new stage
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("Black Moodle");
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Error loading the signup page: " + e.getMessage());
        }
    }
    @FXML
    private void handleSignupButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String lastname = lastNameField.getText();
        String name = nameField.getText();
        String email = emailField.getText();
        Gender gender = comboboxg.getValue();

        // Validate input fields
        if (username.isEmpty() || password.isEmpty() || lastname.isEmpty() || name.isEmpty() || gender == null) {
            showAlert(Alert.AlertType.ERROR, "Signup Failed", "Please fill in all the required fields.");
            return;
        }

        // Optional: You can add more validation for email format if needed

        // Proceed with signup
        if (email.isEmpty()) {
            email = "";
        }
        ArrayList<String> newlogindates = new ArrayList<>();
        ArrayList<Course> teacherCourses = new ArrayList<>();
        ArrayList<Course> stdCourses = new ArrayList<>();
        String personalToken = Security.generateToken();
        String passwordHashed = Encryption.hashPassword(password);
        User.addUser(personalToken, username, passwordHashed, name, lastname, 2, email, null, gender, newlogindates,teacherCourses,stdCourses);
        System.out.println(":DDD");
        navigateToLoginPage(event);
    }
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        // Set custom colors directly
        switch (type) {
            case ERROR:
                setAlertColors(alert, "#ced4da", "#0077b6", "#34495E", "#6c757d");
                break;
            // Add cases for other alert types if needed

            default: // Default colors
                break;
        }

        alert.showAndWait();
    }

    private void setAlertColors(Alert alert, String backgroundColor, String headerColor, String contentColor, String buttonColor) {
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: " + backgroundColor + ";");

        Label titleLabel = (Label) dialogPane.lookup(".alert-header");
        if (titleLabel != null) {
            titleLabel.setStyle("-fx-background-color: " + headerColor + "; -fx-text-fill: #000000;");
        }

        Label contentLabel = (Label) dialogPane.lookup(".alert-content");
        if (contentLabel != null) {
            contentLabel.setStyle("-fx-text-fill: " + contentColor + ";");
        }

        ButtonBar buttonBar = (ButtonBar) dialogPane.lookup(".button-bar");
        if (buttonBar != null) {
            buttonBar.getButtons().forEach(button -> button.setStyle("-fx-background-color: " + buttonColor + "; -fx-text-fill: #000000;"));
        }
    }


    @FXML
    private void navigateToLoginPage(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("Login.fxml"));
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

