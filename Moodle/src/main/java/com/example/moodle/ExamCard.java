package com.example.moodle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class ExamCard {

    @FXML
    private Label name;

    @FXML
    private Label course;

    @FXML
    private Button start;
    @FXML
    private void navigateExaming(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("examing.fxml"));
        try {
            Parent examPage = fxmlLoader.load();
//<<<<<<< HEAD
//
//=======
//>>>>>>> 7a9153b4380f56b4aa0acfb96548cd4a8ca2aae3
            Stage stage = (Stage) start.getScene().getWindow();
            Scene newPage = new Scene(examPage);
            stage.setScene(newPage);
            stage.setTitle("exam");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setData(Quiz quiz){
        name.setText(quiz.getName());
        course.setText(quiz.getCourse().toString());

    }
}
