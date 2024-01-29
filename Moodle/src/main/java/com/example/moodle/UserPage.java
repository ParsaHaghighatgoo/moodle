package com.example.moodle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

import java.io.IOException;

public class UserPage {

    @FXML
    private Slider VolumeSlider;
    @FXML
    private TextArea loginActivity;
    @FXML
    private Label ChooseMusic;
    private User logedInUser;

    @FXML
    private AnchorPane profilePane;
    @FXML
    private AnchorPane listPane;
    @FXML
    private AnchorPane leftPane;
    @FXML
    private Button profileButton;

    private static MediaPlayer mediaPlayer;

    private static Media media;


    @FXML
    void Reset(MouseEvent event) {
        UserPage.mediaPlayer.seek(Duration.seconds(0));
    }
    @FXML
    void Start(MouseEvent event) {
        UserPage.mediaPlayer.play();
    }
    @FXML
    void Stop(MouseEvent event) {
        UserPage.mediaPlayer.pause();
    }

    @FXML
    void Volume(MouseEvent event) {
        VolumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                UserPage.mediaPlayer.setVolume(VolumeSlider.getValue() * 0.01);
            }
        });
    }
    @FXML
    void chooseMusic(MouseEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select you Music");
        File file = chooser.showOpenDialog(null);
        if (file != null){
            String selectedfile = file.toURI().toString();
            UserPage.media = new Media(selectedfile);
            UserPage.mediaPlayer = new MediaPlayer(UserPage.media);
            UserPage.mediaPlayer.setOnReady(() -> {
                ChooseMusic.setText(file.getName());
            });
        }

    }



    public void initialize() {
        leftPane.setVisible(true);
        listPane.setVisible(true);
        profilePane.setVisible(false);
        profileButton.setText("Profile");

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

    public void updateLoginActivityBoxText(String dates) {
        loginActivity.setText(dates);
    }

    public void setLogedInUser(User logedInUser) {
        this.logedInUser = logedInUser;
    }


}
