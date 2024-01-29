package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Exam {

    @FXML
    private TextField name;
    @FXML
    private TextField course;
    @FXML
    private TextField time;
    private User logedInUser;

    @FXML
    private Button create;

    @FXML
    private AnchorPane root;

    @FXML
    private ScrollPane exam_list;


    @FXML
    private Button backButton;
    private Course selected_course;

    private ArrayList<Quiz> allQuizzes;


    public Course getCourse() {
        return selected_course;
    }

    public void setCourse(Course selected_course) {
        this.selected_course = selected_course;
    }



    public void initialize() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true); // Make the ScrollPane fit its content width

// Create a VBox to hold the AnchorPanes
        AnchorPane contentPane = new AnchorPane();
        scrollPane.setContent(contentPane);

// Create an HBox to hold the ScrollPane and the back button
        VBox hbox = new VBox(scrollPane, backButton);

// Add the HBox to the mainPane
        root.getChildren().add(hbox);
        AnchorPane.setTopAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
        AnchorPane.setBottomAnchor(hbox, 0.0);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        // Initialize the course cards
        try {
            double topAnchor = 0; // Initial top anchor value
            allQuizzes = DataBase.quizzes;
            for (Quiz quiz : allQuizzes) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExamCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ExamCard examCard = fxmlLoader.getController();
                AnchorPane.setTopAnchor(anchorPane, topAnchor);
                examCard.setData(quiz);
                examCard.setQuiz(quiz);
                exam_list.setContent(anchorPane);
                // Update the top anchor value for the next AnchorPane
                topAnchor += anchorPane.getPrefHeight() + 20; // Assuming a spacing of 30 between AnchorPanes

                // Add the AnchorPane to the contentPane
                contentPane.getChildren().add(anchorPane);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    protected void ShowTeacherCoursesBackButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllCourseList.fxml"));
            Parent courseListsParent = fxmlLoader.load();

            AllCourseList courseListsController = fxmlLoader.getController();

            courseListsController.initializeView(); // Initialize the CourseLists view

            // Get the current stage from the welcomeText label (or any other node in the scene graph)
            Stage stage = (Stage) backButton.getScene().getWindow();

            Scene courseListsScene = new Scene(courseListsParent);

            // Set the scene on the current stage
            stage.setScene(courseListsScene);
            stage.setTitle("Courses");
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading the CourseLists page: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for detailed error logging
        }
    }

}
