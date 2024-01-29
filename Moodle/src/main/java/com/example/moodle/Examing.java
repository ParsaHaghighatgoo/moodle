package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Examing {

    @FXML
    private ButtonBar buttonBar;
    @FXML
    private Button prev;
    @FXML
    private Button finish;
    @FXML
    private Button cancel2;
    @FXML
    private AnchorPane finish_page;
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
            test.setVisible(true);
            descriptive.setVisible(false);
            finish_page.setVisible(false);
            buttonBar.setVisible(true);
            testQuestion.setText(question.getQuestionTest());
            tcheckA.setText(question.getOption1());
            tcheckB.setText(question.getOption2());
            tcheckC.setText(question.getOption3());
            tcheckD.setText(question.getOption4());
            counter ++;
        } else {
            test.setVisible(false);
            descriptive.setVisible(true);
            finish_page.setVisible(false);
            buttonBar.setVisible(true);
            descriptiveQuestion.setText(question.getQuestionDes());
            counter++;
        }
    }

    @FXML
    private void show_questions(){
        Question question = quiz.questions.get(counter);
        if (question.getQtype().equals(QuestionType.TEST) && counter != quiz.questions.size()-1){
            test.setVisible(true);
            descriptive.setVisible(false);
            finish_page.setVisible(false);
            buttonBar.setVisible(true);
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
        } else if (counter != quiz.questions.size()-1 && question.getQtype().equals(QuestionType.DESCRIPTIVE)){
            test.setVisible(false);
            descriptive.setVisible(true);
            finish_page.setVisible(false);
            buttonBar.setVisible(true);
            descriptiveQuestion.setText(question.getQuestionDes());
            counter++;
        } else {
            test.setVisible(false);
            descriptive.setVisible(false);
            finish_page.setVisible(true);
            buttonBar.setVisible(true);
        }
    }

    @FXML
    public void submitTest(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
            Parent root = fxmlLoader.load();
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("User Page");
            currentStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the user page: " + e.getMessage());
        }
    }

    @FXML
    private void handle_cancel_button(){
        setQuiz(quiz);
    }

    @FXML
    private void handle_finish_button(){
        test.setVisible(false);
        descriptive.setVisible(false);
        finish_page.setVisible(true);
        buttonBar.setVisible(false);
    }

    @FXML
    private void handle_prev_button(){
        counter -= 2;
        show_questions();
    }
}
