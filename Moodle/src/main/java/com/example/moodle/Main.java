package com.example.moodle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Black Moodle");
        stage.getIcons().add(new Image("C:\\Users\\beta\\Desktop\\moodle\\Moodle\\src\\main\\resources\\com\\example\\moodle\\icon.jpg"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        dataBase.initilizeDataBase();
    }
}
