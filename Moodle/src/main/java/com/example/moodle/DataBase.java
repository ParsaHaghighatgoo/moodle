package com.example.moodle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
    static ArrayList<User> users = new ArrayList<>();

    public void initializeDataBase() {
        // Your existing initialization code
        ArrayList<String> newLoginDates = new ArrayList<>();
        users.clear();
        User admin = new User(1, "admin", "admin", "admin", "admin", "admin@gmail.com", 2, UserRole.ADMIN, Gender.OTHERS, newLoginDates);
        users.add(admin);


        // Convert the users list to JSON and save it to a file
        saveUsersToJson("sample.json");

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
