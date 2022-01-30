module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.rmi;

    exports client;
    exports client.controllers;
    opens client.controllers to javafx.fxml;
    opens client to javafx.fxml;
}