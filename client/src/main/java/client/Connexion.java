package client;

import client.controllers.ConnexionController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Connexion extends Application {

    private String nomMag = "";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Connexion.class.getResource("connexion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ConnexionController ctrl = (ConnexionController) fxmlLoader.getController();
        ctrl.setNomMag(nomMag);
        ctrl.setSt(stage);
        stage.setScene(scene);
        stage.show();
    }

    public Connexion() {}

    public Connexion(Stage stage,String nomMag) {
        this.nomMag = nomMag;
        try {
            start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
