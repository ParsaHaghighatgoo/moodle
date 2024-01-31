package com.example.moodle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteExam {

    @FXML
    private AnchorPane root;
    @FXML
    private Button backButton;
    @FXML
    private ScrollPane exam_list;
    private Course selected_course = AllCourseList.selected_course;

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
            ArrayList<Quiz> allQuizzes = DataBase.quizzes;
            for (Quiz quiz : allQuizzes) {
                System.out.println(quiz.course);
                System.out.println(selected_course);
                if (quiz.course.equals(selected_course)){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("delete_card.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    DeleteCard deleteCard = fxmlLoader.getController();
                    AnchorPane.setTopAnchor(anchorPane, topAnchor);
                    deleteCard.setData(quiz);
                    deleteCard.setQuiz(quiz);
                    exam_list.setContent(anchorPane);
                    // Update the top anchor value for the next AnchorPane
                    topAnchor += anchorPane.getPrefHeight() + 20; // Assuming a spacing of 30 between AnchorPanes

                    // Add the AnchorPane to the contentPane
                    contentPane.getChildren().add(anchorPane);
                }
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

            courseListsController.initialize(); // Initialize the CourseLists view

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
