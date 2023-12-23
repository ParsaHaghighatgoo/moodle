package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button login;



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

    private void navigateToAdminPage(User authenticatedUser) {
        // This code is for navigating to the AdminPage after successful login
        // Uncomment the code and make sure you have a reference to the current stage
        /*
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
            Parent adminPageParent = fxmlLoader.load();
            AdminPage adminPageController = fxmlLoader.getController();
            adminPageController.setAuthenticatedUser(authenticatedUser);  // Pass the authenticated user

            Scene adminScene = new Scene(adminPageParent);

            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(adminScene);
            stage.setTitle("Admin Page");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    @FXML
    void handleSignup(ActionEvent event) {
        // Navigate to the signup page or perform other actions.
        System.out.println("Signup button clicked!");
    }
}
