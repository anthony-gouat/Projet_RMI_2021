package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        getStage().setScene(scene);
        getStage().show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }
}
