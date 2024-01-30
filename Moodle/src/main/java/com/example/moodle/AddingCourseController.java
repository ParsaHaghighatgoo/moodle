package com.example.moodle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class AddingCourseController {
    @FXML
    private TextField CourseName;

    private AllCourseList parentController;

    public void setParentController(AllCourseList parentController) {
        this.parentController = parentController;
    }

    @FXML
    private void addCourse() throws IOException {
        // Get user input from the text fields
        String courseName = CourseName.getText();
        // Get more details as needed

        // Create a new Course object
        Course newCourse = new Course(courseName,  "", new ArrayList<>(), new ArrayList<>());

        // Add the new course to the data source (e.g., DataBase.courses)
        DataBase.courses.add(newCourse);

        // Update the UI with the new course
        parentController.initialize(); // You may need to adjust this method based on your implementation

        // Close the "Add Course" window
        CourseName.getScene().getWindow().hide();
    }
}
