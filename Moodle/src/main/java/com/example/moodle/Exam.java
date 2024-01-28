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
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private ButtonBar button_bar;

    @FXML
    private ScrollPane exam_list;

    @FXML
    private AnchorPane create_exam;

    @FXML
    private Button newButton;

    @FXML
    private Button backButton;
    private Course selected_course;

    public Course getCourse() {
        return selected_course;
    }

    public void setCourse(Course selected_course) {
        this.selected_course = selected_course;
    }

    public void initialize(){
        create_exam.setVisible(true);
    }
    @FXML
    private void handleNewButton(){
        exam_list.setVisible(false);
        create_exam.setVisible(true);
    }
    @FXML
    private void handleCreateButton(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newExam.fxml"));
        try {
            Parent new_exam = fxmlLoader.load();
            Stage stage = (Stage) create.getScene().getWindow();
            Scene newPage = new Scene(new_exam);
            stage.setScene(newPage);
            stage.setTitle("exam");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void ShowTeacherCoursesBackButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllCourseList.fxml"));
            Parent courseListsParent = fxmlLoader.load();

            AllCourseList courseListsController = fxmlLoader.getController();
            courseListsController.setLogedInUser(logedInUser);
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

    @FXML
    private void navigateExaming(){
        Quiz quiz = new Quiz(name.getText(),selected_course,time.getText());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("examing.fxml"));
        try {
            Parent examPage = fxmlLoader.load();
            NewExam newExam = fxmlLoader.getController();
            newExam.setSelectedQuiz(quiz);
            Stage stage = (Stage) create.getScene().getWindow();
            Scene newPage = new Scene(examPage);
            stage.setScene(newPage);
            stage.setTitle("exam");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
