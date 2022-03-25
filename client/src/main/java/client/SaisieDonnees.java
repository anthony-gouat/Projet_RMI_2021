package client;

import client.controllers.PanierController;
import client.controllers.SaisieDonneesController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SaisieDonnees extends Application {

    MagasinInterface magasin = null;
    float total = 0;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Panier.class.getResource("saisie_donnees.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        SaisieDonneesController ctrl = (SaisieDonneesController) fxmlLoader.getController();

        ctrl.setSt(stage);
        ctrl.setTotal(total);
        ctrl.setMagasin(magasin);
        ctrl.afficheArticles();
        stage.setScene(scene);
        stage.show();
    }

    public SaisieDonnees(Stage stage,MagasinInterface magasin,float total) {
        this.magasin=magasin;
        this.total=total;
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
