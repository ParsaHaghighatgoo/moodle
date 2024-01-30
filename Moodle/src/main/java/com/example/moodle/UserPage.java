package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class UserPage {

    @FXML
    private TextArea tokenLabel;
    @FXML
    private Button exam;

    @FXML
    private Label loginActivity;

    public User logedInUser = Login.logedInUser;

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


//    public void setLogedInUser(User logedInUser) {
//        this.logedInUser = logedInUser;
//    }

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

            courseListsController.initialize(); // Initialize the CourseLists view

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
            courseListsController.initialize2(); // Initialize the CourseLists view

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
    protected void ShowGottenCoursesButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllCourseList.fxml"));
            Parent courseListsParent = fxmlLoader.load();

            AllCourseList courseListsController = fxmlLoader.getController();
            courseListsController.initialize3(); // Initialize the CourseLists view

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
//        double index1 = 0;
//        double index2 = 0;
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        System.out.println(logedInUser);

        for (Course course : logedInUser.getTeacherCourses()) {
//            System.out.println(course);
            double index1 = 25;

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseCardUserPage.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            CourseCardUserPage courseCard = fxmlLoader.getController();
            courseCard.setData(course);

            hBox1.getChildren().add(anchorPane);
            HBox.setMargin(anchorPane, new Insets(0, 0, 0, index1));

        }
        for (Course course : logedInUser.getStdCourses()) {

            double index2 = 25;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseCardUserPage.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            CourseCardUserPage courseCard = fxmlLoader.getController();
            courseCard.setData(course);

            hBox2.getChildren().add(anchorPane);
            HBox.setMargin(anchorPane, new Insets(0, 0, 0, index2));

        }
        scrollPane.setContent(hBox1);
        scrollPane2.setContent(hBox2);
    }


    public void updateLoginActivityBoxText(String dates) {
        loginActivity.setText(dates);
    }
    public void updateTokenLable(String token){
        tokenLabel.setText(token);
    }







    @FXML

    private void navigateToAddingCoursePage(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(UserPage.class.getResource("AddingCourse.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new stage
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("AddCourse");
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Error loading the ADdingCourse page: " + e.getMessage());
        }
    }









}
