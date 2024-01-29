package com.example.moodle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;


public class User {
    public static Random randomIdGen = new Random();

    int personalToken;
    String username;
    String password;
    String firstName;
    String lastName;
    ArrayList<Course> teacherCourses = new ArrayList<>();
    ArrayList<Course> stdCourses = new ArrayList<>();
    int Age;
    String email;
    UserRole userRole;
    Gender gender;
    ArrayList<String> logindates;


    public User(int id, String username, String password, String firstName,
                String lastName, int age, String email,
                UserRole userRole, Gender gender, ArrayList<String> logindates
                ,ArrayList<Course> teacherCourses ,ArrayList<Course> stdCourses ) {
        this.personalToken = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        Age = age;
        this.email = email;
        this.userRole = userRole;
        this.gender = gender;
        this.logindates = logindates;
        this.teacherCourses = teacherCourses;
        this.stdCourses = stdCourses;
    }

    public User() {
    }

    public int getId() {
        return personalToken;
    }

    public void setId(int id) {
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
                ", userRole=" + userRole +
                ", gender=" + gender +
                '}';
    }

    public static void addUser(int id, String username, String password, String firstName
            , String lastName, int age, String email, UserRole userRole, Gender gender, ArrayList<String> logindates,
                               ArrayList<Course> teacherCourses,
                               ArrayList<Course> stdCourses) {
        User newUser = new User(id, username, password, firstName, lastName,age,email
                 , userRole, gender, logindates,teacherCourses,stdCourses);
        DataBase.users.add(newUser);
    }


}
