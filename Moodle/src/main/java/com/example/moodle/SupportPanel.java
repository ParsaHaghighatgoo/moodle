package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SupportPanel {
    private User logedInUser = Login.logedInUser;

    @FXML
    private void backToUserPage(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //System.out.println(String.valueOf(now).substring(0,19));
        logedInUser.logindates.add(dtf.format(now));
        String personalTokenString = "Personal Token: "+logedInUser.personalToken;
        String newLogAct = "your first login is : " + logedInUser.logindates.get(0) + "\n"
                + "your last login is : " +  logedInUser.logindates.get(logedInUser.logindates.size()-1);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
            Parent root = fxmlLoader.load();
            UserPage userPage = fxmlLoader.getController();
//            userPage.setLogedInUser(logedInUser);
            userPage.updateLoginActivityBoxText(newLogAct);
            userPage.updateTokenLable(personalTokenString);
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("User Page");
            currentStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the user page: " + e.getMessage());
        }
    }
}
