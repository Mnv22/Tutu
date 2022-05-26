module com.example.tutu {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.tutu to javafx.fxml;
    exports com.example.tutu;
}