module com.example.eshoey {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql.rowset;


    opens com.example.eshoey to javafx.fxml;
    exports com.example.eshoey;

}
