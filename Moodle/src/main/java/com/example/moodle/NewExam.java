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
import java.util.Objects;

public class NewExam {

    @FXML
    private AnchorPane descriptive;

    @FXML
    private AnchorPane test;

    @FXML
    private Button test2;

    @FXML
    private Button descriptive2;
    @FXML
    private TextField testQuestion;
    @FXML
    private TextField A;
    @FXML
    private TextField B;
    @FXML
    private TextField C;
    @FXML
    private TextField D;
    @FXML
    private CheckBox correct_choiceA;
    @FXML
    private CheckBox correct_choiceB;
    @FXML
    private CheckBox correct_choiceC;
    @FXML
    private CheckBox correct_choiceD;
    private String QtypeFlag = "test";
    @FXML
    private TextField descriptiveQuestion;
    @FXML
    private TextField descriptiveAnswer;
    public Quiz selectedQuiz;

    public Quiz getSelectedQuiz() {
        return selectedQuiz;
    }
    public void initialize(){
        test.setVisible(true);
        descriptive.setVisible(false);
    }

    public void setSelectedQuiz(Quiz selectedQuiz) {
        this.selectedQuiz = selectedQuiz;
    }
//<<<<<<< HEAD
    public void submitTest() {
        System.out.println(selectedQuiz);
//=======
    }
    @FXML
    private void testSelected(){
        QtypeFlag = "test";
        test.setVisible(true);
        descriptive.setVisible(false);
        test2.defaultButtonProperty();
    }

    @FXML
    private void DescriptiveSelected(){
        QtypeFlag = "descriptive";
        test.setVisible(false);
        descriptive.setVisible(true);
        descriptive2.defaultButtonProperty();
//>>>>>>> 7a9153b4380f56b4aa0acfb96548cd4a8ca2aae3
    }

    @FXML
    private void handleNextButton(){
        if(Objects.equals(QtypeFlag, "test")) {
            String testQ = testQuestion.getText();
            String a = A.getText();
            String b = B.getText();
            String c = C.getText();
            String d = D.getText();
            CheckBox correctAnswer = null;
            if (correct_choiceA.isSelected()) {
                correctAnswer = correct_choiceA;
            } else if (correct_choiceB.isSelected()) {
                correctAnswer = correct_choiceB;
            } else if (correct_choiceC.isSelected()) {
                correctAnswer = correct_choiceC;
            } else if (correct_choiceD.isSelected()) {
                correctAnswer = correct_choiceD;
            }
            Question testQuestion = new Question(testQ, a, b, c, d, correctAnswer, QuestionType.TEST);
            selectedQuiz.addQuestion(testQuestion);

            System.out.println(selectedQuiz);
        }
        if(Objects.equals(QtypeFlag, "descriptive")){
            String descriptiveQ = descriptiveQuestion.getText();
            String descriptiveAns = descriptiveAnswer.getText();

            Question DecQuestion = new Question(descriptiveQ, descriptiveAns, QuestionType.DESCRIPTIVE);
            selectedQuiz.addQuestion(DecQuestion);
            System.out.println(selectedQuiz);
        }

    }
}
