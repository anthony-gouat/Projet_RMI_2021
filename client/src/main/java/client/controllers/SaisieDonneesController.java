package client.controllers;

import client.MagasinInterface;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SaisieDonneesController {
    private Stage st;
    private MagasinInterface magasin;
    private float total = 0;

    public SaisieDonneesController(){
    }

    @FXML
    VBox vboxrecap;
    public void afficheArticles(){
        Pane pane = new Pane();
        Label lbltotal = new Label("Total : "+ total +"€");
        lbltotal.setMaxWidth(Double.MAX_VALUE);
        lbltotal.setAlignment(Pos.CENTER);
        pane.getChildren().add(lbltotal);
        vboxrecap.getChildren().add(pane);
    }

    public void setSt(Stage st) {
        this.st = st;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setMagasin(MagasinInterface magasin) {
        this.magasin=magasin;
    }
}
