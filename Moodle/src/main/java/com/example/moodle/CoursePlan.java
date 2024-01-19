package com.example.moodle;

import java.util.ArrayList;

public class CoursePlan {
    ArrayList<Student> students;
    ArrayList<Professor> professors;

    public CoursePlan(ArrayList<Student> students, ArrayList<Professor> professors) {
        this.students = students;
        this.professors = professors;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

}
