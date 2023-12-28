package com.example.moodle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Black Moodle");
        String localDir = System.getProperty("user.dir");
        localDir+="\\src\\main\\resources\\com\\example\\moodle\\icon.jpg"  ;
        System.out.println(localDir);
        stage.getIcons().add(new Image(localDir));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        dataBase.initilizeDataBase();
        launch();
    }
}
