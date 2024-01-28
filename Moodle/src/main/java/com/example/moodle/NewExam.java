package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class NewExam {

    @FXML
    private AnchorPane descriptive;

    @FXML
    private AnchorPane test;

    @FXML
    private Button test2;

    @FXML
    private Button descriptive2;
    Quiz selectedQuiz;

    public Quiz getSelectedQuiz() {
        return selectedQuiz;
    }

    public void setSelectedQuiz(Quiz selectedQuiz) {
        this.selectedQuiz = selectedQuiz;
    }

    @FXML
    private void testSelected(){
        test.setVisible(true);
        descriptive.setVisible(false);
        test2.defaultButtonProperty();
    }

    @FXML
    private void DescriptiveSelected(){
        test.setVisible(false);
        descriptive.setVisible(true);
        descriptive2.defaultButtonProperty();
    }
}
