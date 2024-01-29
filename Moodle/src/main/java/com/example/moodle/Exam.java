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




    public void initialize() throws IOException {
        double top = 0;
        allQuizzes = DataBase.quizzes;
        for (Quiz quiz:allQuizzes){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExamCard.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            ExamCard examCard = fxmlLoader.getController();
            examCard.setData(quiz);
            exam_list.setContent(anchorPane);
            AnchorPane.setRightAnchor(anchorPane,top);
            top += anchorPane.getPrefWidth() + 20;
        }
    }
    @FXML
    private void handleCreateButton(){
        Quiz quiz = new Quiz(name.getText(),selected_course,time.getText());

//<<<<<<< HEAD
//
//=======
//>>>>>>> 7a9153b4380f56b4aa0acfb96548cd4a8ca2aae3
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("examing.fxml"));
        try {
            Parent examPage = fxmlLoader.load();
//<<<<<<< HEAD
//
//=======
//>>>>>>> 7a9153b4380f56b4aa0acfb96548cd4a8ca2aae3
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
