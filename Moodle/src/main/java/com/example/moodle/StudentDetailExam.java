package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class StudentDetailExam {
    @FXML
    private ImageView courseImage;
    @FXML
    private Label name;
    @FXML
    private Label course;
    @FXML
    private Label teacher;
    @FXML
    private Label Lgrade;
    @FXML
    private ListView<Question> correct;
    @FXML
    private ListView<Question> noAnswer;
    @FXML
    private ListView<Question> wrong;
    @FXML
    private Quiz quiz;
    @FXML
    private Button back;


    public void initialize(){
        name.setText(quiz.getName());
        course.setText(quiz.getCourse().toString());
        teacher.setText("nothing now");
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public StudentDetailExam(int text_grade ) {
        Lgrade.setText(String.valueOf(text_grade));
    }

//    @FXML
//    private void handle_back(){
//        Stage currentStage = (Stage) back.getScene().getWindow();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        //System.out.println(String.valueOf(now).substring(0,19));
//        logedInUser.logindates.add(dtf.format(now));
//        String personalTokenString = "Personal Token: "+logedInUser.personalToken;
//        String newLogAct = "your first login is : " + logedInUser.logindates.get(0) + "\n"
//                + "your last login is : " +  logedInUser.logindates.get(logedInUser.logindates.size()-1);
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
//            Parent root = fxmlLoader.load();
//            UserPage userPage = fxmlLoader.getController();
////            userPage.setLogedInUser(logedInUser);
//            userPage.updateLoginActivityBoxText(newLogAct);
//            userPage.updateTokenLable(personalTokenString);
//            currentStage.setScene(new Scene(root));
//            currentStage.setTitle("User Page");
//            currentStage.show();
//        } catch (IOException e) {
//            System.err.println("Error loading the user page: " + e.getMessage());
//        }
//    }
}
