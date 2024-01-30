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
        boolean found = false;

        for (User user : DataBase.users) {
            if (usernameText.equals(user.username) && tokenText.equals(user.personalToken)) {
                found = true;
                this.loggedInUser = user;
                falsePane.setVisible(true);
                correctPane.setVisible(true);
                BackPane.setVisible(false);
                return;
            }
        }
        // Display error if username or token is invalid
        if (!found) {
            showAlert(Alert.AlertType.ERROR, "Reset Password Failed", "Invalid username or token.");
        }
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
