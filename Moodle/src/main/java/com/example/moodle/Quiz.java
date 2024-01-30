package com.example.moodle;

import java.util.ArrayList;

public class Quiz {
    ArrayList<Question> questions = new ArrayList<>();
    Course course;
    String name;
    String time;

    public ArrayList<User> user_done_exam = new ArrayList<>();

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

    public void addQuestion(Question question){
        this.questions.add(question);
    }
    @Override
    public String toString() {
        return "Quiz {\n" +
                "\tquestions=" + questions + ",\n" +
                "\tcourse=" + course + ",\n" +
                "\tname='" + name + '\'' + ",\n" +
                "\ttime='" + time + '\'' + "\n" +
                "}\n";
    }

}