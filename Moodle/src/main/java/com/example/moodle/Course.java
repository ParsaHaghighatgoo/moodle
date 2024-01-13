package com.example.moodle;

import java.util.ArrayList;

public class Course {
    ArrayList<CoursePlan> coursePlans = new ArrayList<>();
    String CourseImagePath;
    ArrayList<String> CourseVideos;
    ArrayList<String> CourseDocs;


    public Course(ArrayList<CoursePlan> coursePlans, String courseImagePath, ArrayList<String> courseVideos, ArrayList<String> courseDocs) {
        this.coursePlans = coursePlans;
        CourseImagePath = courseImagePath;
        CourseVideos = courseVideos;
        CourseDocs = courseDocs;
    }

    public Course() {
    }

    public ArrayList<CoursePlan> getCoursePlans() {
        return coursePlans;
    }

    public void setCoursePlans(ArrayList<CoursePlan> coursePlans) {
        this.coursePlans = coursePlans;
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
        return "Course{" +
                "coursePlans=" + coursePlans +
                ", CourseImagePath='" + CourseImagePath + '\'' +
                ", CourseVideos=" + CourseVideos +
                ", CourseDocs=" + CourseDocs +
                '}';
    }
}
