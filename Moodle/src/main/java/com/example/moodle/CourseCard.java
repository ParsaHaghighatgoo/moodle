package com.example.moodle;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.InputStream;

public class CourseCard {
    @FXML
    private AnchorPane CoursePane;
    @FXML
    private ImageView CourseImage;

    public void setData(Course course){
        String imageUrl = course.getCourseImagePath();
        if (imageUrl != null && !imageUrl.trim().isEmpty()) {
            InputStream imageStream = getClass().getResourceAsStream(imageUrl);
            if (imageStream != null) {
                Image image = new Image(imageStream);
                CourseImage.setImage(image);
            } else {
                System.err.println("Failed to load image: " + imageUrl);
            }
        } else {
            System.err.println("Image URL is null or empty for course: " + course);
        }

        CoursePane.setStyle("-fx-background-color: black");
    }

}
