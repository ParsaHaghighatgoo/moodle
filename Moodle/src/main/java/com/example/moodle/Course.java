package com.example.moodle;

import java.util.ArrayList;

public class Course {
    ArrayList<CoursePlan> coursePlans = new ArrayList<>();
    String CourseImagePath;

    public Course(ArrayList<CoursePlan> coursePlans, String courseImagePath) {
        this.coursePlans = coursePlans;
        CourseImagePath = courseImagePath;
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

    public void setCourseImagePath(String courseImagePath) {
        CourseImagePath = courseImagePath;
    }

    @Override
    public String toString() {
        return "Course{" +
                "coursePlans=" + coursePlans +
                ", CourseImagePath='" + CourseImagePath + '\'' +
                '}';
    }
}
