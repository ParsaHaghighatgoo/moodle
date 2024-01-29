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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Login {

    @FXML
    private Button resetPassButton;
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button login;

    private Button signupbutton;

    private String newLogAct;
    private String personalTokenString;
    private User logedInUser;



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
                this.logedInUser = user;
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                //System.out.println(String.valueOf(now).substring(0,19));
                user.logindates.add(dtf.format(now));
                personalTokenString = "Save this token for Authentications:\n"+user.personalToken;
                newLogAct = "your first login is : " + user.logindates.get(0) + "\n"
                + "your last login is : " +  user.logindates.get(user.logindates.size()-1);
                //UserPage.updateLoginActivityBoxText(newLogAct);
                navigateToUserPage(event);
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
    @FXML
    private void navigateToUserPage(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
            Parent root = fxmlLoader.load();
            UserPage userPage = fxmlLoader.getController();
            userPage.setLogedInUser(logedInUser);
            userPage.updateLoginActivityBoxText(newLogAct);
            userPage.updateTokenLable(personalTokenString);
            //Create a new stage
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("User Page");
            currentStage.show();


        } catch (IOException e) {
            System.err.println("Error loading the signup page: " + e.getMessage());
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
