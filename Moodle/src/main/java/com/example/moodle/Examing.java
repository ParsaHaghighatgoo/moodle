package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Examing {


    @FXML
    private TextArea descriptiveAnswer;

    @FXML
    private TextArea descriptiveQuestion;

    @FXML
    private Button nextQuestion;

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

    private final User logedInUser = Login.logedInUser;

    private Quiz quiz;


    private static int counter;

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
        counter = 0;
        Question question = quiz.questions.get(counter);
        if (question.getQtype().equals(QuestionType.TEST)){
            testQuestion.setText(question.getQuestionTest());
            tcheckA.setText(question.getOption1());
            tcheckB.setText(question.getOption2());
            tcheckC.setText(question.getOption3());
            tcheckD.setText(question.getOption4());
            counter ++;
        } else {
            test.setVisible(false);
            descriptive.setVisible(true);
            descriptiveQuestion.setText(question.getQuestionDes());
            counter++;
        }
    }

    @FXML
    private void show_questions(){
        Question question = quiz.questions.get(counter);
        if (question.getQtype().equals(QuestionType.TEST)){
            testQuestion.setText(question.getQuestionTest());
            tcheckA.setText(question.getOption1());
            tcheckB.setText(question.getOption2());
            tcheckC.setText(question.getOption3());
            tcheckD.setText(question.getOption4());
            counter ++;
            tcheckA.setSelected(false);
            tcheckB.setSelected(false);
            tcheckC.setSelected(false);
            tcheckD.setSelected(false);
        } else {
            test.setVisible(false);
            descriptive.setVisible(true);
            descriptiveQuestion.setText(question.getQuestionDes());
            counter++;
        }
    }

    @FXML
    public void submitTest(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
            Parent root = fxmlLoader.load();
            UserPage userPage = fxmlLoader.getController();
            userPage.setLogedInUser(logedInUser);
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("User Page");
            currentStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the user page: " + e.getMessage());
        }
    }
}
