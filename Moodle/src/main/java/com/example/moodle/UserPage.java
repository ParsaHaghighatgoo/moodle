package com.example.moodle;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class UserPage {

    @FXML
    private static TextArea loginActivity;

    public static void updateLoginActivityBoxText(String newText) {
        loginActivity.setText(newText);
    }

    public static void uplog(String string){
        updateLoginActivityBoxText(string);
    }


}
