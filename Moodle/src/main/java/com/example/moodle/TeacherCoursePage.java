package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherCoursePage {

//<<<<<<< HEAD
//=======
    @FXML
    private Button add_exam;

    private void initialize(){
        add_exam.setOnAction(this::add_new_exam);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Exam.fxml"));
        try {
            Parent new_exam = fxmlLoader.load();
            Stage stage = (Stage) add_exam.getScene().getWindow();
            Scene newPage = new Scene(new_exam);
//            Exam exam = fxmlLoader.getController();
//            exam.setCourse(course);
            stage.setScene(newPage);
            stage.setTitle("exam");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//>>>>>>> 8d77ac6ad49ccc8f38e3440189e01b82cabbb0a0
}
