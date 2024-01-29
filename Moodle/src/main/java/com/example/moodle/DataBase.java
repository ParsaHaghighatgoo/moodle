package com.example.moodle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Quiz> quizzes = new ArrayList<>();
    public void initializeDataBase() {
        // Your existing initialization code
        ArrayList<String> newLoginDates = new ArrayList<>();
        Course course = new Course(null, "download.jpg", null, null);
        Course course2 = new Course(null, "icon.jpg", null, null);
        Course course3 = new Course(null, "in.jpg", null, null);
        Course course4 = new Course(null, "innner1.jpg", null, null);

        courses.add(course);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);

        users.clear();
        ArrayList<Course> adminTeacherCourse= new ArrayList<>();
        adminTeacherCourse.add(course);
        ArrayList<Course> adminStdCourse= new ArrayList<>();
        //String adminPersonalToken = Security.generateToken();
        String adminPersonalToken = "E0eCjZqSVzU=";
        User admin = new User(adminPersonalToken, "admin", "admin", "admin", "admin", 2,"admin@gmail.com", UserRole.ADMIN, Gender.OTHERS, newLoginDates,adminTeacherCourse
        ,adminStdCourse);

        admin.teacherCourses.add(course);
        admin.teacherCourses.add(course2);
        admin.stdCourses.add(course3);
        admin.stdCourses.add(course4);

        String admin2PersonalToken = "E0pCjzQS4zU=";
        User admin2 = new User(admin2PersonalToken, "admin2", "admin2", "admin2", "admin2", 2,"admin2@gmail.com", UserRole.ADMIN, Gender.OTHERS, newLoginDates,adminTeacherCourse,adminStdCourse);
        admin2.teacherCourses.add(course3);
        admin2.teacherCourses.add(course2);
        admin2.stdCourses.add(course);
        admin2.stdCourses.add(course4);

        users.add(admin);
        users.add(admin2);

        // Convert the users list to JSON and save it to a file
        saveUsersToJson("sample.json");
        saveCoursesToJson("course.json");

        // Read users from JSON during initialization
        readUsersFromJson("sample.json");
    }

    private void saveUsersToJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(users);
            // Save the JSON string to a file
            objectMapper.writeValue(new File(fileName), users);
            // For simplicity, let's just print it for now
            System.out.println("Saved JSON: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveCoursesToJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(courses);
            // Save the JSON string to a file
            objectMapper.writeValue(new File(fileName), courses);
            // For simplicity, let's just print it for now
            System.out.println("Saved JSON: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readUsersFromJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read the JSON from the file
            File file = new File(fileName);
            if (file.exists()) {
                ArrayList<User> loadedUsers = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
