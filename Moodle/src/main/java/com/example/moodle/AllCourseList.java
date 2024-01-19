package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AllCourseList {
    @FXML
    private AnchorPane mainPane;
    private ArrayList<Course> AllCourses;

    private User logedInUser;
    public void setLogedInUser(User logedInUser) {
        this.logedInUser = logedInUser;
    }

    public void initialize() {

        AllCourses = DataBase.courses;
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true); // Make the ScrollPane fit its content width

// Create a VBox to hold the AnchorPanes
        AnchorPane contentPane = new AnchorPane();
        scrollPane.setContent(contentPane);

// Add the back button
        Button backButton = new Button("Back");
        backButton.setOnAction(this::backToUserPage); // Assuming handleBackButton is your back button logic

// Create an HBox to hold the ScrollPane and the back button
        HBox hbox = new HBox(scrollPane, backButton);

// Add the HBox to the mainPane
        mainPane.getChildren().add(hbox);
        AnchorPane.setTopAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
        AnchorPane.setBottomAnchor(hbox, 0.0);
        AnchorPane.setLeftAnchor(hbox, 0.0);
        // Initialize the course cards
        try {
            double topAnchor = 0; // Initial top anchor value

            for (Course course : AllCourses) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                CourseCard courseCard = fxmlLoader.getController();

                if (!course.isTeacherCourse()){
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

                            //Create a new stage
                            currentStage.setScene(new Scene(root));
                            currentStage.setTitle("Teacher Course Page");
                            currentStage.show();

                        } catch (IOException e) {
                            System.err.println("Error loading the Teacher Course Page: " + e.getMessage());
                        }
                    });
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize2() {
        AllCourses = DataBase.courses;
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true); // Make the ScrollPane fit its content width

// Create a VBox to hold the AnchorPanes
        AnchorPane contentPane = new AnchorPane();
        scrollPane.setContent(contentPane);

// Add the back button
        Button backButton = new Button("Back");
        backButton.setOnAction(this::backToUserPage); // Assuming handleBackButton is your back button logic

// Create an HBox to hold the ScrollPane and the back button
        HBox hbox = new HBox(scrollPane, backButton);

// Add the HBox to the mainPane
        mainPane.getChildren().add(hbox);
        AnchorPane.setTopAnchor(hbox, 0.0);
        AnchorPane.setRightAnchor(hbox, 0.0);
        AnchorPane.setBottomAnchor(hbox, 0.0);
        AnchorPane.setLeftAnchor(hbox, 0.0);

        // Initialize the course cards
        try {
            double topAnchor = 0; // Initial top anchor value

            for (Course course : AllCourses) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                CourseCard courseCard = fxmlLoader.getController();

                if (course.isTeacherCourse()){
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

                            //Create a new stage
                            currentStage.setScene(new Scene(root));
                            currentStage.setTitle("Teacher Course Page");
                            currentStage.show();


                        } catch (IOException e) {
                            System.err.println("Error loading the Teacher Course Page: " + e.getMessage());
                        }
                    });
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Add this method to initialize the CourseLists view
    public void initializeView() {
        initialize();
    }
    public void initializeView2() {
        initialize2();
    }

    @FXML
    private void backToUserPage(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
            Parent root = fxmlLoader.load();
            UserPage userPage = fxmlLoader.getController();
            userPage.setLogedInUser(logedInUser);

            currentStage.setScene(new Scene(root));
            currentStage.setTitle("User Page");
            currentStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the user page: " + e.getMessage());
        }
    }

}
