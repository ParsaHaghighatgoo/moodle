package com.example.moodle;

public class User {
    int id;
    String username;
    String password;
    String firstName;
    String LastName;
    int Age;
    UserRole userRole;
    Gender gender;

    public User(int id, String username, String password, String firstName, String lastName, int age, UserRole userRole, Gender gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        LastName = lastName;
        Age = age;
        this.userRole = userRole;
        this.gender = gender;
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
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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
                ", LastName='" + LastName + '\'' +
                ", Age=" + Age +
                ", userRole=" + userRole +
                ", gender=" + gender +
                '}';
    }
}
