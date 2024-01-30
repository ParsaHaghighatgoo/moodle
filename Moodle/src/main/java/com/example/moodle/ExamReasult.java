package com.example.moodle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ExamReasult {
    @FXML
    public Label grade;
    @FXML
    public ListView<String> Correct;
    @FXML
    public ListView<String> No;
    @FXML
    public ListView<String> Wrong;

    public void initialize() {
        grade.setText(String.valueOf(Examing.grade));
//        populateLists();
    }

//    private void populateLists() {
//        for (Question question : Examing.correct_answer) {
//            Correct.getItems().add(question.getQuestionText()); // Assuming you have a method to get the question text
//        }
//
//        for (Question question : Examing.no_answer) {
//            No.getItems().add(question.getQuestionText()); // Assuming you have a method to get the question text
//        }
//
//        for (Question question : Examing.wrong_answer) {
//            Wrong.getItems().add(question.getQuestionText()); // Assuming you have a method to get the question text
//        }
//    }
}
