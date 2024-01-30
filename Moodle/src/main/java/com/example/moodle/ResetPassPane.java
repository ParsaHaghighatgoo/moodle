package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResetPassPane {

    @FXML
    private AnchorPane BackPane;
    @FXML
    private TextField NewPass;
    @FXML
    private AnchorPane checkPane;
    @FXML
    private AnchorPane falsePane;
    @FXML
    private AnchorPane correctPane;
    @FXML
    private TextField username;
    @FXML
    private TextField token;
    private User loggedInUser = Login.logedInUser;


    public void initialize() throws IOException {
        checkPane.setVisible(true);
        correctPane.setVisible(false);
        falsePane.setVisible(false);
        BackPane.setVisible(false);

    }
    @FXML
    void handleCheck(ActionEvent event) {
        String usernameText = username.getText();
        String tokenText = token.getText();
        for (User user : DataBase.users) {
            if (usernameText.equals(user.username) && tokenText.equals(user.personalToken)) {
                System.out.println(user);
                this.loggedInUser = user;
                falsePane.setVisible(true);
                correctPane.setVisible(true);
                BackPane.setVisible(false);
                return;
            }
        }
        falsePane.setVisible(true);
        correctPane.setVisible(false);
        BackPane.setVisible(false);
        System.out.println("not found!");
    }
    @FXML
    void handleSubmit(ActionEvent event) {
        String newPass = NewPass.getText();
        loggedInUser.setPassword(newPass);
        BackPane.setVisible(true);
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
    private void handleBackButton(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent loginPageParent = fxmlLoader.load();
            Scene loginScene = new Scene(loginPageParent);
            currentStage.setScene(loginScene);
            currentStage.setTitle("Login page!");
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Error loading login page : " + e.getMessage());
        }
    }

}
