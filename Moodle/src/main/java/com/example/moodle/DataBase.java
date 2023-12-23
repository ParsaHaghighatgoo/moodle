package com.example.moodle;

import java.util.ArrayList;

public class DataBase {
    static ArrayList<User> users = new ArrayList<>();

    public void initilizeDataBase(){
        User admin = new User(1,"admin","admin","admin","admin",2,UserRole.ADMIN,Gender.OTHERS);
        users.add(admin);


    }
}
