module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.rmi;


    opens client to javafx.fxml;
    exports client;
}