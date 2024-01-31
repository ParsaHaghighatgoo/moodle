package com.example.moodle;

import java.util.ArrayList;

public class Course {
    String name;

    String CourseImagePath;
    ArrayList<String> CourseVideos;
    ArrayList<String> CourseDocs;

    ArrayList<Quiz> quizzes = new ArrayList<>();


    public Course(String name, String courseImagePath, ArrayList<String> courseVideos, ArrayList<String> courseDocs) {
        this.name = name;
        CourseImagePath = courseImagePath;
        CourseVideos = courseVideos;
        CourseDocs = courseDocs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course() {
    }




    public String getCourseImagePath() {
        return CourseImagePath;
    }

    public ArrayList<String> getCourseVideos() {
        return CourseVideos;
    }

    public void setCourseVideos(String courseVideos) {
        CourseVideos.add(courseVideos);
    }

    public ArrayList<String> getCourseDocs() {
        return CourseDocs;
    }


    public void setCourseDocs(String courseDocs) {
        CourseDocs.add(courseDocs);
    }

    public void setCourseImagePath(String courseImagePath) {
        CourseImagePath = courseImagePath;
    }


    @Override
    public String toString() {
        return "Course {\n" +
                "\tCourseImagePath='" + CourseImagePath + "',\n" +
                "\tCourseVideos=" + CourseVideos + ",\n" +
                "\tCourseDocs=" + CourseDocs + ",\n" +
                "}";
    }

}
