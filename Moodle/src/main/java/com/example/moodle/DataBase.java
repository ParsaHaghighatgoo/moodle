package com.example.moodle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class DataBase {
    static ArrayList<User> users = new ArrayList<>();

    public void initilizeDataBase(){
        ArrayList<String> newlogindates = new ArrayList<>();
        User admin = new User(1,"admin","admin","admin","admin","admin@gamil.com",2,UserRole.ADMIN,Gender.OTHERS,newlogindates);
        users.add(admin);


    }
}
