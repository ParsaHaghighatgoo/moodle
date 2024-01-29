package com.example.moodle;

import java.util.ArrayList;

public class Course {
    ArrayList<User> users;
    String CourseImagePath;
    ArrayList<String> CourseVideos;
    ArrayList<String> CourseDocs;



    public Course(ArrayList<User> users, String courseImagePath, ArrayList<String> courseVideos, ArrayList<String> courseDocs) {
        this.users = users;
        CourseImagePath = courseImagePath;
        CourseVideos = courseVideos;
        CourseDocs = courseDocs;
    }

    public Course() {
    }


    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getCourseImagePath() {
        return CourseImagePath;
    }

    public ArrayList<String> getCourseVideos() {
        return CourseVideos;
    }

    public void setCourseVideos(ArrayList<String> courseVideos) {
        CourseVideos = courseVideos;
    }

    public ArrayList<String> getCourseDocs() {
        return CourseDocs;
    }


    public void setCourseDocs(ArrayList<String> courseDocs) {
        CourseDocs = courseDocs;
    }

    public void setCourseImagePath(String courseImagePath) {
        CourseImagePath = courseImagePath;
    }

    @Override
    public String toString() {
        return "Course {\n" +
                "\tusers=" + users + ",\n" +
                "\tCourseImagePath='" + CourseImagePath + "',\n" +
                "\tCourseVideos=" + CourseVideos + ",\n" +
                "\tCourseDocs=" + CourseDocs + ",\n" +
                "}";
    }

}
