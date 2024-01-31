package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DocInputPanel {
    @FXML
    private TextField courseName;
    @FXML
    private TextField docLink;
    @FXML
    private void navigateToTeacherCoursePane(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(Signup.class.getResource("TeacherCoursePage.fxml"));
            Parent root = fxmlLoader2.load();

            //TeacherCoursePage teacherCoursePage = fxmlLoader2.getController();
            //teacherCoursePage.setCourse(course);
            //Create a new stage
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("Teacher Course Page");
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Error loading the Teacher Course Page: " + e.getMessage());
        }

    }
    @FXML
    private void Submit(ActionEvent event) {
        String link = docLink.getText();
        String course = courseName.getText();
        for (Course course1: DataBase.courses){
            if (course1.name.equals(course)){
                course1.setCourseDocs(link);
                break;
            }
        }
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(Signup.class.getResource("TeacherCoursePage.fxml"));
            Parent root = fxmlLoader2.load();

            //TeacherCoursePage teacherCoursePage = fxmlLoader2.getController();
            //teacherCoursePage.setCourse(course);
            //Create a new stage
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("Teacher Course Page");
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Error loading the Teacher Course Page: " + e.getMessage());
        }

    }
}
