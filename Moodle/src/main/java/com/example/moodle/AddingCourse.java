package com.example.moodle;

import com.example.moodle.Course;
import com.example.moodle.UserPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static com.example.moodle.Login.logedInUser;

public class AddingCourse {
    @FXML
    private TextField CourseName;  // Make sure to match this ID with the one in FXML
    @FXML
    private TextField imagePath;

    private UserPage parentController;

    public void setParentController(UserPage parentController) {
        this.parentController = parentController;
    }


    @FXML
    public void AddingTheCourse(ActionEvent actionEvent) {
        // Get user input from the text fields
        String courseName = CourseName.getText();
        String ImagePath = imagePath.getText();
        Course course = new Course(courseName , ImagePath ,null , null);
        logedInUser.teacherCourses.add(course);

        // Close the "Adding Course" window
        navigateToUserPage(actionEvent);
    }

    private void navigateToUserPage(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
            Parent root = fxmlLoader.load();
            UserPage userPage = fxmlLoader.getController();
            System.out.println(logedInUser); // Print loggedInUser for debugging
//            userPage.setLogedInUser(logedInUser);
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
