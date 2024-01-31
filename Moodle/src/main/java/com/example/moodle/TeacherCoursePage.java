package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherCoursePage {

    @FXML
    private Button delete;

    @FXML
    private Button back;

    @FXML
    private AnchorPane create_exam;

    @FXML
    private Button create;

    @FXML
    private TextField name;

    @FXML
    private TextField time;

    @FXML
    private Button add_exam;


    private final User logedInUser = Login.logedInUser;

    private void initialize(){
        add_exam.setOnAction(this::add_new_exam);
        create_exam.setVisible(false);
    }
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @FXML
    private void add_new_exam(ActionEvent event){
        // Check for empty fields
        if (name.getText().isEmpty() || time.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in all the required fields.");
            return;
        }
        Quiz quiz = new Quiz(name.getText(), course, time.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newExam.fxml"));
        try {
            Parent new_exam = fxmlLoader.load();
            NewExam newExam = fxmlLoader.getController();
            newExam.setSelectedQuiz(quiz);
            Stage stage = (Stage) create.getScene().getWindow();
            Scene newPage = new Scene(new_exam);
            stage.setScene(newPage);
            stage.setTitle("exam");
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the new exam page.");
            e.printStackTrace(); // Print the stack trace for detailed error logging
        }
    }
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        // Set custom colors directly
        switch (type) {
            case ERROR:
                setAlertColors(alert, "#ced4da", "#9d0208", "#9d0208", "#6c757d");
                break;
            // Add cases for other alert types if needed

            default: // Default colors
                break;
        }

        alert.showAndWait();
    }

    private void setAlertColors(Alert alert, String backgroundColor, String headerColor, String contentColor, String buttonColor) {
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: " + backgroundColor + ";");

        Label titleLabel = (Label) dialogPane.lookup(".alert-header");
        if (titleLabel != null) {
            titleLabel.setStyle("-fx-background-color: " + headerColor + "; -fx-text-fill: #000000;");
        }

        Label contentLabel = (Label) dialogPane.lookup(".alert-content");
        if (contentLabel != null) {
            contentLabel.setStyle("-fx-text-fill: " + contentColor + ";");
        }

        ButtonBar buttonBar = (ButtonBar) dialogPane.lookup(".button-bar");
        if (buttonBar != null) {
            buttonBar.getButtons().forEach(button -> button.setStyle("-fx-background-color: " + buttonColor + "; -fx-text-fill: #000000;"));
        }
    }


    @FXML
    private void handle_add_button(){
        create_exam.setVisible(true);
    }

    @FXML
    protected void ShowTeacherCoursesButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllCourseList.fxml"));
            Parent courseListsParent = fxmlLoader.load();

            AllCourseList courseListsController = fxmlLoader.getController();
            courseListsController.setLogedInUser(logedInUser);
            courseListsController.initialize(); // Initialize the CourseLists view

            // Get the current stage from the welcomeText label (or any other node in the scene graph)
            Stage stage = (Stage) back.getScene().getWindow();

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
    private void handle_delete_button(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("delete_exam.fxml"));
        try {
            Parent new_exam = fxmlLoader.load();
            Stage stage = (Stage) delete.getScene().getWindow();
            Scene newPage = new Scene(new_exam);
            stage.setScene(newPage);
            stage.setTitle("deleting");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
