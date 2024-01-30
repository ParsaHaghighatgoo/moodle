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
import java.util.ArrayList;

public class Examing {

    @FXML
    private Button submit;
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

    int grade;
    ArrayList<Question> correct_answer = new ArrayList<>();
    ArrayList<Question> no_answer = new ArrayList<>();
    ArrayList<Question> wrong_answer = new ArrayList<>();

    ArrayList<Question> answer_question = new ArrayList<>();
    private static int counter;

    public void setQuiz(Quiz quiz) {
        System.out.println(quiz);
        this.quiz = quiz;
        counter = 0;
        for (User user:quiz.user_done_exam){
            if (user.equals(logedInUser)){
                System.out.println("you can't take this quiz again");
                Stage currentStage = (Stage) submit.getScene().getWindow();
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
        }
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
        if (counter == 1){
        Question previousQ = quiz.questions.get(0);
        check_choose_user(previousQ,tcheckA,tcheckB,tcheckC,tcheckD);
        }
        Question question = quiz.questions.get(counter);
        if (question.getQtype().equals(QuestionType.TEST)){
            if (counter == quiz.questions.size()){
                handle_finish_button();
            }
            counter ++;
            test.setVisible(true);
            descriptive.setVisible(false);
            finish_page.setVisible(false);
            buttonBar.setVisible(true);
            testQuestion.setText(question.getQuestionTest());
            tcheckA.setText(question.getOption1());
            tcheckB.setText(question.getOption2());
            tcheckC.setText(question.getOption3());
            tcheckD.setText(question.getOption4());
            check_choose_user(question,tcheckA,tcheckB,tcheckC,tcheckD);
            tcheckA.setSelected(false);
            tcheckB.setSelected(false);
            tcheckC.setSelected(false);
            tcheckD.setSelected(false);
        } else if (question.getQtype().equals(QuestionType.DESCRIPTIVE)){
            if (counter == quiz.questions.size()){
                handle_finish_button();
            }
            counter++;
            test.setVisible(false);
            descriptive.setVisible(true);
            finish_page.setVisible(false);
            buttonBar.setVisible(true);
            descriptiveQuestion.setText(question.getQuestionDes());

        }
    }

    @FXML
    public void submitTest() {
        quiz.user_done_exam.add(logedInUser);
        calculate_grade(quiz.questions);
        System.out.println(grade);
        Stage currentStage = (Stage) submit.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("student_detail_exam.fxml"));
            Parent root = fxmlLoader.load();
            StudentDetailExam studentDetailExam = new StudentDetailExam(grade);
            studentDetailExam.setQuiz(quiz);
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("exam detail");
            currentStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the user page: " + e.getMessage());
        }
    }

    @FXML
    private void handle_cancel_button(){
        counter = 0;
        show_questions();
    }

    @FXML
    private void handle_finish_button(){
        Question now = quiz.questions.get(counter-1);
        check_choose_user(now,tcheckA,tcheckB,tcheckC,tcheckD);
        test.setVisible(false);
        descriptive.setVisible(false);
        finish_page.setVisible(true);
        buttonBar.setVisible(false);
    }

    @FXML
    private void handle_prev_button(){
        Question now = quiz.questions.get(counter-1);
        check_choose_user(now,tcheckA,tcheckB,tcheckC,tcheckD);
        counter -= 2;
        show_questions();
    }

    private void calculate_grade(ArrayList<Question> questions){
        for (Question question:questions){
            if (question.getQtype().equals(QuestionType.TEST)){
                if (question.getUser_answer().isEmpty()){
                    no_answer.add(question);
                } else if (question.getUser_answer().equals(question.getCorrect_answer())) {
                    correct_answer.add(question);
                    grade++;
                } else {
                    wrong_answer.add(question);
                }
            }
        }
    }


    private boolean search_question(Question question,ArrayList<Question> answer_question){
        if (answer_question.isEmpty()) {return true;}
        else {
            for (Question question1:answer_question){
                if (question1.equals(question)){return false;}
            }
            return true;
        }
    }

    private void check_choose_user(Question question,CheckBox a,CheckBox b,CheckBox c,CheckBox d){
        if (a.isSelected()){question.setUser_answer(a.getText());}
        else if (b.isSelected()){
            question.setUser_answer(b.getText());
        }else if (c.isSelected()){
            question.setUser_answer(c.getText());
        }else if (d.isSelected()){
            question.setUser_answer(d.getText());
        }

    }
}
