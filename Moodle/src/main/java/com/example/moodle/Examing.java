package com.example.moodle;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class Examing {

    @FXML
    private CheckBox tcheckA;

    @FXML
    private CheckBox tcheckB;

    @FXML
    private CheckBox tcheckC;

    @FXML
    private CheckBox tcheckD;

    @FXML
    private TextArea testQuestion;

    @FXML
    private AnchorPane test;

    @FXML
    private AnchorPane descriptive;

    private Quiz quiz;

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void initialize(){
        for (Question question:quiz.getQuestions()){
            testQuestion.setText(question.getQuestionTest());
            tcheckB.setText(question.getOption2());
            tcheckA.setText(question.getOption1());
            tcheckC.setText(question.getOption3());
            tcheckD.setText(question.getOption4());
        }
    }
}
