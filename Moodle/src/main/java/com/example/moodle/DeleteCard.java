package com.example.moodle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteCard {

    @FXML
    private Label name;

    @FXML
    private Label course;

    @FXML
    private Button start;

    private Quiz quiz;

    @FXML
    private void deleting_exam(){
        DataBase.quizzes.remove(quiz);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllCourseList.fxml"));
            Parent courseListsParent = fxmlLoader.load();

            AllCourseList courseListsController = fxmlLoader.getController();

            courseListsController.initialize(); // Initialize the CourseLists view

            // Get the current stage from the welcomeText label (or any other node in the scene graph)
            Stage stage = (Stage) start.getScene().getWindow();

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

    public void setData(Quiz quiz){
        name.setText(quiz.getName());
        course.setText(quiz.getCourse().toString());
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
