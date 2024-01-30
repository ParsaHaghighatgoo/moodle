package com.example.moodle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;


public class User {

    String personalToken;
    String username;
    String password;
    String firstName;
    String lastName;
    ArrayList<Course> teacherCourses = new ArrayList<>();
    ArrayList<Course> stdCourses = new ArrayList<>();
    int Age;
    String email;

    Gender gender;
    ArrayList<String> logindates;


    public User(String personalToken, String username, String password, String firstName,
                String lastName, int age, String email,
                 Gender gender, ArrayList<String> logindates
                ,ArrayList<Course> teacherCourses ,ArrayList<Course> stdCourses ) {
        this.personalToken = personalToken;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        Age = age;
        this.email = email;
        this.gender = gender;
        this.logindates = logindates;

    }

    public User() {
    }

    public String getId() {
        return personalToken;
    }

    public void setId(String id) {
        this.personalToken = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }



    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<Course> getTeacherCourses() {
        return teacherCourses;
    }

    public void setTeacherCourses(ArrayList<Course> teacherCourses) {
        this.teacherCourses = teacherCourses;
    }

    public ArrayList<Course> getStdCourses() {
        return stdCourses;
    }

    public void setStdCourses(ArrayList<Course> stdCourses) {
        this.stdCourses = stdCourses;
    }

    @Override
    public String toString() {
        return "User{" +
                "personalToken=" + personalToken +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", Age=" + Age +
                ", gender=" + gender +
                '}';
    }

    public static void addUser(String personalToken, String username, String password, String firstName
            , String lastName, int age, String email, UserRole userRole, Gender gender, ArrayList<String> logindates,
                               ArrayList<Course> teacherCourses,
                               ArrayList<Course> stdCourses) {
        User newUser = new User(personalToken, username, password, firstName, lastName,age,email
                 , gender, logindates,teacherCourses,stdCourses);
        DataBase.users.add(newUser);
    }


}
