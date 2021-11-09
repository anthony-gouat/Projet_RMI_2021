module com.example.testjfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testjfx to javafx.fxml;
    exports com.example.testjfx;
}