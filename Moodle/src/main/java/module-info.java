module com.example.moodle {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires javafx.media;


    opens com.example.moodle to javafx.fxml;
    exports com.example.moodle;
}