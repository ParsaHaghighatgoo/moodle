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

    private Button submit;
    @FXML
    private AnchorPane descriptive;

    @FXML
    private AnchorPane test;

    @FXML
    private Button test2;

    @FXML
    private Button descriptive2;
    @FXML
    private TextField testQuestion1;
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

    private final User logedInUser = Login.logedInUser;

    @FXML
    private Button prev;


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

    @FXML
    public void submitTest(ActionEvent event) {
        DataBase.quizzes.add(selectedQuiz);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
            Parent root = fxmlLoader.load();
            UserPage userPage = fxmlLoader.getController();

            currentStage.setScene(new Scene(root));
            currentStage.setTitle("User Page");
            currentStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the user page: " + e.getMessage());
        }
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
    }

    @FXML
    private void handleNextButton(){
        if(Objects.equals(QtypeFlag, "test")) {
            // Check for empty fields
            if (testQuestion1.getText().isEmpty() || A.getText().isEmpty() || B.getText().isEmpty() ||
                    C.getText().isEmpty() || D.getText().isEmpty() || (!correct_choiceA.isSelected() &&
                    !correct_choiceB.isSelected() && !correct_choiceC.isSelected() && !correct_choiceD.isSelected())) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in all the required fields and select the correct answer.");
                return;
            }

            // Process test question
            String testQ = testQuestion1.getText();
            String a = A.getText();
            String b = B.getText();
            String c = C.getText();
            String d = D.getText();
            CheckBox correctAnswer = correct_choiceA.isSelected() ? correct_choiceA :
                    correct_choiceB.isSelected() ? correct_choiceB :
                            correct_choiceC.isSelected() ? correct_choiceC :
                                    correct_choiceD;
            Question testQuestion = new Question(testQ, a, b, c, d, correctAnswer, QuestionType.TEST);
            selectedQuiz.addQuestion(testQuestion);
            clearTestFields();
        }
        if(Objects.equals(QtypeFlag, "descriptive")){
            // Check for empty fields
            if (descriptiveQuestion.getText().isEmpty() || descriptiveAnswer.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in all the required fields.");
                return;
            }

            // Process descriptive question
            String descriptiveQ = descriptiveQuestion.getText();
            String descriptiveAns = descriptiveAnswer.getText();
            Question DecQuestion = new Question(descriptiveQ, descriptiveAns, QuestionType.DESCRIPTIVE);
            selectedQuiz.addQuestion(DecQuestion);
            clearDescriptiveFields();
        }
    }

    private void clearTestFields() {
        testQuestion1.clear();
        A.clear();
        B.clear();
        C.clear();
        D.clear();
        correct_choiceA.setSelected(false);
        correct_choiceB.setSelected(false);
        correct_choiceC.setSelected(false);
        correct_choiceD.setSelected(false);
    }

    private void clearDescriptiveFields() {
        descriptiveQuestion.clear();
        descriptiveAnswer.clear();
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
    private void handle_cancel_button(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
            Parent root = fxmlLoader.load();
            UserPage userPage = fxmlLoader.getController();


            currentStage.setScene(new Scene(root));
            currentStage.setTitle("User Page");
            currentStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the user page: " + e.getMessage());
        }
    }

}
