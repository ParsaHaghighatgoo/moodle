package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherCoursePage {

    @FXML
    private Button back;

    @FXML
    private AnchorPane create_exam;

    @FXML
    private Button create;

    @FXML
    private TextField name;

    @FXML
    private TextField time;

    @FXML
    private Button add_exam;
    Course selectedCourse;


    private final User logedInUser = Login.logedInUser;

    private void initialize(){
        add_exam.setOnAction(this::add_new_exam);
        create_exam.setVisible(false);
    }
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @FXML
    private void add_new_exam(ActionEvent event){
        Quiz quiz = new Quiz(name.getText(),course,time.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newExam.fxml"));
        try {
            Parent new_exam = fxmlLoader.load();
            NewExam newExam = fxmlLoader.getController();
            newExam.setSelectedQuiz(quiz);
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
    private void handle_add_button(){
        create_exam.setVisible(true);
    }

    @FXML
    protected void ShowTeacherCoursesButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllCourseList.fxml"));
            Parent courseListsParent = fxmlLoader.load();

            AllCourseList courseListsController = fxmlLoader.getController();
            courseListsController.setLogedInUser(logedInUser);
            courseListsController.initializeView(); // Initialize the CourseLists view

            // Get the current stage from the welcomeText label (or any other node in the scene graph)
            Stage stage = (Stage) back.getScene().getWindow();

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
