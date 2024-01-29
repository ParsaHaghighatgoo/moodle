package com.example.moodle;

import java.util.ArrayList;

public class Course {
    ArrayList<User> users;
    String CourseImagePath;
    ArrayList<String> CourseVideos;
    ArrayList<String> CourseDocs;
    boolean isTeacherCourse;


    public Course(ArrayList<User> users, String courseImagePath, ArrayList<String> courseVideos, ArrayList<String> courseDocs, boolean isTeacherCourse) {
        this.users = users;
        CourseImagePath = courseImagePath;
        CourseVideos = courseVideos;
        CourseDocs = courseDocs;
        this.isTeacherCourse = isTeacherCourse;
    }

    public Course() {
    }

    public boolean isTeacherCourse() {
        return isTeacherCourse;
    }

    public void setTeacherCourse(boolean teacherCourse) {
        isTeacherCourse = teacherCourse;
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
                "\tisTeacherCourse=" + isTeacherCourse + "\n" +
                "}";
    }

}
