package client;

import client.controllers.PageMagasinController;
import client.controllers.PanierController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Panier extends Application {
    MagasinInterface magasin = null;
    int idpanier = 0;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Panier.class.getResource("panier.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PanierController ctrl = (PanierController) fxmlLoader.getController();
        ArrayList<String[]> listarticles = magasin.afficheArticlesPanier(idpanier);
        for (String[] article : listarticles) {
            System.out.println(article[2]+" : qte = "+article[7]);
        }
        ctrl.setSt(stage);
        ctrl.setIdpanier(idpanier);
        ctrl.setMagasin(magasin);
        stage.setScene(scene);
        ctrl.afficheArticlesPanier(listarticles);
        stage.show();
    }

    public Panier(Stage stage,MagasinInterface magasin,int idpanier) {
        this.magasin=magasin;
        this.idpanier=idpanier;
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
