package com.example.moodle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class StudentDetailExam {
    private ImageView courseImage;
    private Label name;
    private Label course;
    private Label teacher;
    private Label Lgrade;
    private ListView correct;
    private ListView noAnswer;
    private ListView wrong;

    @FXML
    private Button back;


    public void setCourseImage(ImageView courseImage) {
        this.courseImage = courseImage;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public void setCourse(Label course) {
        this.course = course;
    }

    public void setTeacher(Label teacher) {
        this.teacher = teacher;
    }

    public void setLgrade(Label lgrade) {
        Lgrade = lgrade;
    }

    public void setCorrect(ListView correct) {
        this.correct = correct;
    }

    public void setNoAnswer(ListView noAnswer) {
        this.noAnswer = noAnswer;
    }

    public void setWrong(ListView wrong) {
        this.wrong = wrong;
    }

    public ImageView getCourseImage() {
        return courseImage;
    }

    public Label getName() {
        return name;
    }

    public Label getCourse() {
        return course;
    }

    public Label getTeacher() {
        return teacher;
    }

    public Label getLgrade() {
        return Lgrade;
    }

    public ListView getCorrect() {
        return correct;
    }

    public ListView getNoAnswer() {
        return noAnswer;
    }

    public ListView getWrong() {
        return wrong;
    }
}
