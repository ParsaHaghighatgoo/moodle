module com.example.moodle {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires java.mail;


    opens com.example.moodle to javafx.fxml;
    exports com.example.moodle;
}