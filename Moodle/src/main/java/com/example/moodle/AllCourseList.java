package com.example.moodle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AllCourseList {
    @FXML
    private AnchorPane mainPane;
    private ArrayList<Course> AllCourses;

    public void initialize() {
        AllCourses = DataBase.courses;

        // Create a ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true); // Make the ScrollPane fit its content width

        // Create a VBox to hold the AnchorPanes
        AnchorPane contentPane = new AnchorPane();
        scrollPane.setContent(contentPane);

        // Add the ScrollPane to the mainPane
        mainPane.getChildren().add(scrollPane);
        AnchorPane.setTopAnchor(scrollPane, 0.0);
        AnchorPane.setRightAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(scrollPane, 0.0);
        AnchorPane.setLeftAnchor(scrollPane, 0.0);

        // Initialize the course cards
        try {
            double topAnchor = 0; // Initial top anchor value

            for (Course course : AllCourses) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                CourseCard courseCard = fxmlLoader.getController();
                courseCard.setData(course);


                // Set the top and left anchors for the current AnchorPane
                AnchorPane.setTopAnchor(anchorPane, topAnchor);

                // Update the top anchor value for the next AnchorPane
                topAnchor += anchorPane.getPrefHeight() + 30; // Assuming a spacing of 30 between AnchorPanes

                // Add the AnchorPane to the contentPane
                contentPane.getChildren().add(anchorPane);

                // Add mouse click event handler to the AnchorPane
                anchorPane.setOnMouseClicked(event -> {
                    // Handle the course selection here
                    System.out.println("Selected course: " + course);
                    // TODO: Implement the selection logic
                    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    try {
                        FXMLLoader fxmlLoader2 = new FXMLLoader(Signup.class.getResource("TeacherCoursePage.fxml"));
                        Parent root = fxmlLoader2.load();
                        TeacherCoursePage teacherCoursePage = fxmlLoader2.getController();

                        //Create a new stage
                        currentStage.setScene(new Scene(root));
                        currentStage.setTitle("Teacher Course Page");
                        currentStage.show();


                    } catch (IOException e) {
                        System.err.println("Error loading the Teacher Course Page: " + e.getMessage());
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add this method to initialize the CourseLists view
    public void initializeView() {
        initialize();
    }
}
