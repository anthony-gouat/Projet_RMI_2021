package client;

import client.controllers.ConnexionController;
import client.controllers.PageMagasinController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PageMagasin extends Application {
    MagasinInterface magasin = null;
    int idpanier = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PageMagasin.class.getResource("page_magasin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PageMagasinController ctrl = (PageMagasinController) fxmlLoader.getController();
        ArrayList<String[]> listarticles = magasin.afficheArticle();
        ctrl.setSt(stage);
        ctrl.setIdpanier(idpanier);
        ctrl.setMagasin(magasin);
        stage.setScene(scene);
        ctrl.afficheArticles(listarticles);
        stage.show();
    }

    public PageMagasin(Stage stage,MagasinInterface magasin,int idpanier) {
        this.magasin=magasin;
        this.idpanier=idpanier;
        try {
            start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
