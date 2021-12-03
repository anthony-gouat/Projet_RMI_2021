package client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller {
    public static void changeScene(String sceneName){
        Parent root=null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource(sceneName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene=null;
        if( root != null) scene = new Scene(root);
        if( scene != null) Main.getStage().setScene(scene);
        Main.getStage().show();
    }
}
