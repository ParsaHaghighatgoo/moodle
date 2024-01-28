package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class UserPage {

    @FXML
    private Button exam;

    @FXML
    private TextArea loginActivity;

    private User logedInUser;

    @FXML
    private AnchorPane profilePane;
    @FXML
    private AnchorPane listPane;
    @FXML
    private AnchorPane leftPane;
    @FXML
    private Button profileButton;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private ScrollPane scrollPane2;
    @FXML
    private HBox hBox;
    private ArrayList<Course> AllCourses;




    public void initialize() throws IOException {
        leftPane.setVisible(true);
        listPane.setVisible(true);
        profilePane.setVisible(false);
        profileButton.setText("Profile");
        ProfCoursesList();

    }

    @FXML
    protected void ShowTeacherCoursesButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllCourseList.fxml"));
            Parent courseListsParent = fxmlLoader.load();

            AllCourseList courseListsController = fxmlLoader.getController();
            courseListsController.setLogedInUser(logedInUser);
            courseListsController.initializeView(); // Initialize the CourseLists view

            // Get the current stage from the welcomeText label (or any other node in the scene graph)
            Stage stage = (Stage) profilePane.getScene().getWindow();

            Scene courseListsScene = new Scene(courseListsParent);

            // Set the scene on the current stage
            stage.setScene(courseListsScene);
            stage.setTitle("Courses");
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading the CourseLists page: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for detailed error logging
        }
    }
    @FXML
    protected void ShowStudentCoursesButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllCourseList.fxml"));
            Parent courseListsParent = fxmlLoader.load();

            AllCourseList courseListsController = fxmlLoader.getController();
            courseListsController.setLogedInUser(logedInUser);
            courseListsController.initializeView2(); // Initialize the CourseLists view

            // Get the current stage from the welcomeText label (or any other node in the scene graph)
            Stage stage = (Stage) profilePane.getScene().getWindow();

            Scene courseListsScene = new Scene(courseListsParent);

            // Set the scene on the current stage
            stage.setScene(courseListsScene);
            stage.setTitle("Courses");
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading the CourseLists page: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for detailed error logging
        }
    }
    @FXML
    private void handleSignoutButton(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent loginPageParent = fxmlLoader.load();
            Scene loginScene = new Scene(loginPageParent);
            currentStage.setScene(loginScene);
            currentStage.setTitle("Login page!");
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Error loading login page : " + e.getMessage());
        }
    }


    @FXML
    private void handleProfileButton(){
        if (profileButton.getText().equals("Profile")){
            listPane.setVisible(false);
            profilePane.setVisible(true);
            profileButton.setText("Dashboard");
        }
        else {
            listPane.setVisible(true);
            profilePane.setVisible(false);
            profileButton.setText("Profile");
        }
    }

    @FXML
    private void handleExamButton(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Exam.fxml"));
        try {
            Parent new_exam = fxmlLoader.load();
            Stage stage = (Stage) exam.getScene().getWindow();
            Scene newPage = new Scene(new_exam);
            stage.setScene(newPage);
            stage.setTitle("exam");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void ProfCoursesList() throws IOException {
        AllCourses = DataBase.courses;

        for (Course course : AllCourses) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseCard.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            CourseCard courseCard = fxmlLoader.getController();
            if (course.isTeacherCourse()) {
                courseCard.setData(course);
                scrollPane.setContent(anchorPane);
            }
            else {
                courseCard.setData(course);
                scrollPane2.setContent(anchorPane);
            }
        }


    }

    public void updateLoginActivityBoxText(String dates) {
        loginActivity.setText(dates);
    }

    public void setLogedInUser(User logedInUser) {
        this.logedInUser = logedInUser;
    }


}
