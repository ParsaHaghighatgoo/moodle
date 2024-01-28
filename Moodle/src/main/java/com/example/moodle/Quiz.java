package com.example.moodle;

import java.util.ArrayList;

public class Quiz {
    ArrayList<Question> questions;
    Course course;
    String name;
    String time;

    public Quiz( String name,Course course, String time) {
        this.name = name;
        this.course = course;
        this.time = time;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "questions=" + questions +
                ", course=" + course +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}