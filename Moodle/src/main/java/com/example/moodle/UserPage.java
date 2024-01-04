package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserPage {

    @FXML
    private TextArea loginActivity;

    private User logedInUser;

    @FXML
    private AnchorPane profilePane;
    @FXML
    private AnchorPane listPane;
    @FXML
    private AnchorPane leftPane;
    @FXML
    private Button profileButton;


    public void initialize(){
        leftPane.setVisible(true);
        listPane.setVisible(true);
        profilePane.setVisible(false);
        profileButton.setText("Profile");
    }

    @FXML
    private void handleSignoutButton(ActionEvent event) {
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


    @FXML
    private void handleProfileButton(){
        if (profileButton.getText().equals("Profile")){
            listPane.setVisible(false);
            profilePane.setVisible(true);
            profileButton.setText("Dashboard");
        }
        else {
            listPane.setVisible(true);
            profilePane.setVisible(false);
            profileButton.setText("Profile");
        }
    }

    public void updateLoginActivityBoxText(String dates) {
        loginActivity.setText(dates);
    }

    public void setLogedInUser(User logedInUser) {
        this.logedInUser = logedInUser;
    }


}
