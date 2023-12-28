package com.example.moodle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class User {
    int id;
    String username;
    String password;
    String firstName;
    String lastName;
    int Age;
    String email;
    UserRole userRole;
    Gender gender;
    ArrayList<String> logindates;

    public User(int id, String username, String password, String firstName, String lastName, String email
            , int age, UserRole userRole, Gender gender,ArrayList<String> logindates) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.Age = age;
        this.userRole = userRole;
        this.gender = gender;
        this.logindates = logindates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
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
            , String lastName, int age, String email, UserRole userRole, Gender gender,ArrayList<String> logindates) {
        User newUser = new User(id, username, password, firstName, lastName, email
                , age, userRole, gender,logindates);
        DataBase.users.add(newUser);
    }

}
