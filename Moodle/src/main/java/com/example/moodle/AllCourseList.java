package com.example.moodle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class AllCourseList {
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button AddingCourse;
    private ArrayList<Course> AllCourses;
    private User logedInUser = Login.logedInUser;
    @FXML
    private ScrollPane scrollPane;

    public static Course selected_course;

    public void setLogedInUser(User logedInUser) {
        this.logedInUser = logedInUser;
    }


public void initialize() throws IOException {
    VBox hBox1 = new VBox();

    for (Course course : logedInUser.getTeacherCourses()) {
        double index1 = 25;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseCard.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        CourseCard courseCard = fxmlLoader.getController();
        courseCard.setData(course);

        anchorPane.setOnMouseClicked(event -> {
            // Handle the course selection here
            System.out.println("Selected course: " + course);
            // TODO: Implement the selection logic
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            selected_course = course;
            try {
                FXMLLoader fxmlLoader2 = new FXMLLoader(Signup.class.getResource("TeacherCoursePage.fxml"));
                Parent root = fxmlLoader2.load();
                TeacherCoursePage teacherCoursePage = fxmlLoader2.getController();
                teacherCoursePage.setCourse(course);
                //Create a new stage
                currentStage.setScene(new Scene(root));
                currentStage.setTitle("Teacher Course Page");
                currentStage.show();

            } catch (IOException e) {
                System.err.println("Error loading the Teacher Course Page: " + e.getMessage());
            }
        });

        hBox1.getChildren().add(anchorPane);
        HBox.setMargin(anchorPane, new Insets(0, 0, 0, index1));
    }

    scrollPane.setContent(hBox1);
}
    public void initialize2() throws IOException {
        VBox hBox1 = new VBox();

        for (Course course : logedInUser.getStdCourses()) {
            double index1 = 25;

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseCard.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            CourseCard courseCard = fxmlLoader.getController();
            courseCard.setData(course);

            anchorPane.setOnMouseClicked(event -> {
                // Handle the course selection here
                System.out.println("Selected course: " + course);
                // TODO: Implement the selection logic
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                selected_course = course;
                try {
                    FXMLLoader fxmlLoader2 = new FXMLLoader(Signup.class.getResource("StudentCoursePage.fxml"));
                    Parent root = fxmlLoader2.load();

                    //Create a new stage
                    currentStage.setScene(new Scene(root));
                    currentStage.setTitle("Student Course Page");
                    currentStage.show();


                } catch (IOException e) {
                    System.err.println("Error loading the Student Course Page: " + e.getMessage());
                }
            });

            hBox1.getChildren().add(anchorPane);
            HBox.setMargin(anchorPane, new Insets(0, 0, 0, index1));
        }

        scrollPane.setContent(hBox1);
    }

    public void initialize3() throws IOException {
        VBox hBox1 = new VBox();

        for (Course course : DataBase.courses) {
            if (!logedInUser.stdCourses.contains(course)) {
                double index1 = 25;

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                CourseCard courseCard = fxmlLoader.getController();
                courseCard.setData(course);

                anchorPane.setOnMouseClicked(event -> {
                    logedInUser.stdCourses.add(course);
                    // Handle the course selection here
                });

                hBox1.getChildren().add(anchorPane);
                HBox.setMargin(anchorPane, new Insets(0, 0, 0, index1));
            }
        }

        scrollPane.setContent(hBox1);
    }

    @FXML
    private void backToUserPage(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //System.out.println(String.valueOf(now).substring(0,19));
        logedInUser.logindates.add(dtf.format(now));
        String personalTokenString = "Personal Token: "+logedInUser.personalToken;
        String newLogAct = "your first login is : " + logedInUser.logindates.get(0) + "\n"
                + "your last login is : " +  logedInUser.logindates.get(logedInUser.logindates.size()-1);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Signup.class.getResource("userPage.fxml"));
            Parent root = fxmlLoader.load();
            UserPage userPage = fxmlLoader.getController();
//            userPage.setLogedInUser(logedInUser);
            userPage.updateLoginActivityBoxText(newLogAct);
            userPage.updateTokenLable(personalTokenString);
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("User Page");
            currentStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the user page: " + e.getMessage());
        }
    }


}
