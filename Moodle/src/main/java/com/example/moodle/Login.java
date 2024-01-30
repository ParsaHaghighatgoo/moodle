package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Login {
    @FXML
    public AnchorPane loginBack;
    @FXML
    private Button resetPassButton;
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button login;

    @FXML
    private Button signupbutton;

    private String newLogAct;
    private String personalTokenString;
    public static User logedInUser;



    // This method is automatically called by the FXMLLoader when the FXML file is loaded.
    @FXML
    public void initialize() {
        login.setOnAction(this::handleLogin);
    }

    @FXML
    void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean found = false;
        for (User user : DataBase.users) {
            if (username.equals(user.username) && password.equals(user.password)) {
                found = true;
                this.logedInUser = user;
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                user.logindates.add(dtf.format(now));
                personalTokenString = "Personal Token: "+user.personalToken;
                newLogAct = "your first login is : " + user.logindates.get(0) + "\n"
                        + "your last login is : " +  user.logindates.get(user.logindates.size()-1);
                navigateToUserPage(event);
                break;
            }
        }
        if (!found) {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
        // Add CSS file to the scene

    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        // Set custom colors directly
        switch (type) {
            case ERROR:
                setAlertColors(alert, "#ced4da", "#9d0208", "#9d0208", "#6c757d");
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
    @FXML
    private void navigateToUserPage(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
            Parent root = fxmlLoader.load();
            UserPage userPage = fxmlLoader.getController();
            System.out.println(logedInUser); // Print loggedInUser for debugging
//            userPage.setLogedInUser(logedInUser);
            userPage.updateLoginActivityBoxText(newLogAct);
            userPage.updateTokenLable(personalTokenString);
            //Create a new stage

            // Create a new stage

            currentStage.setScene(new Scene(root));
            currentStage.setTitle("User Page");
            currentStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the user page: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } catch (Exception ex) {
            System.err.println("Error navigating to user page: " + ex.getMessage());
            ex.printStackTrace(); // Print stack trace for debugging
        }
    }

    @FXML
    private void navigateToResetPasswordPage(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ResetPassPane.class.getResource("ResetPassPane.fxml"));
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
