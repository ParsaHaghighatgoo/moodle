module com.example.moodle {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.moodle to javafx.fxml;
    exports com.example.moodle;
}