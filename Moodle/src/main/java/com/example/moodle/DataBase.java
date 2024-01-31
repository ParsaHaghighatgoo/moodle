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
        ArrayList<String> courseVideo = new ArrayList<>();
        ArrayList<String> courseDoc = new ArrayList<>();
        ArrayList<String> course2Video = new ArrayList<>();
        ArrayList<String> course2Doc = new ArrayList<>();
        ArrayList<String> course3Video = new ArrayList<>();
        ArrayList<String> course3Doc = new ArrayList<>();
        ArrayList<String> course4Video = new ArrayList<>();
        ArrayList<String> course4Doc = new ArrayList<>();
        ArrayList<String> course5Video = new ArrayList<>();
        ArrayList<String> course5Doc = new ArrayList<>();
        ArrayList<String> course6Video = new ArrayList<>();
        ArrayList<String> course6Doc = new ArrayList<>();
        ArrayList<String> course7Video = new ArrayList<>();
        ArrayList<String> course7Doc = new ArrayList<>();
        Course course = new Course("first", "firstCourse.png", courseVideo, courseDoc);
        Course course2 = new Course("second", "secondCourse.png", course2Video, course2Doc);
        Course course3 = new Course("third", "thirdCourse.png", course3Video, course3Doc);
        Course course4 = new Course("fourth", "fourseCourse.png", course4Video, course4Doc);
        Course course5 = new Course("Fifth", "fourseCourse.png", course5Video, course5Doc);
        Course course6 = new Course("Sixth", "fourseCourse.png", course6Video, course6Doc);
        Course course7 = new Course("Seventh", "fourseCourse.png", course7Video, course7Doc);

        courses.add(course);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);
        courses.add(course7);

        users.clear();
        ArrayList<Course> adminTeacherCourse= new ArrayList<>();
        adminTeacherCourse.add(course);
        ArrayList<Course> adminStdCourse= new ArrayList<>();
        //String adminPersonalToken = Security.generateToken();
        String adminPersonalToken = "E0eCjZqSVzU=";
        String adminPassHash = Encryption.hashPassword("admin");
        User admin = new User(adminPersonalToken, "admin", adminPassHash, "admin", "admin", 2,"admin@gmail.com", Gender.OTHERS, newLoginDates,adminTeacherCourse
        ,adminStdCourse);

        admin.teacherCourses.add(course);
        admin.teacherCourses.add(course2);
        admin.stdCourses.add(course3);
        admin.stdCourses.add(course4);

        String adminPersonalToken2 = "E4eokTqSo9U=";
        String admin2PassHash = Encryption.hashPassword("admin2");
        User admin2 = new User(adminPersonalToken2, "admin2", admin2PassHash, "admin2", "admin2", 2,"admin2@gmail.com", Gender.OTHERS, newLoginDates,adminTeacherCourse,adminStdCourse);
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
