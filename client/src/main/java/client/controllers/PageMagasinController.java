package client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PageMagasinController {

    private Stage st;

    public PageMagasinController(){
    }

    public void setSt(Stage st) {
        this.st = st;
    }

    @FXML
    VBox vbox_art;
    public void afficheArticles(ArrayList<String[]> listarticles){
        for (String[] article : listarticles) {
            vbox_art.getChildren().add(miseEnPageArt(article));
        }
    }

    private Pane miseEnPageArt(String[] article){
        Pane pane = new Pane();
        pane.setMinHeight(50);
        Label lbl = new Label(article[2]);
        lbl.setLayoutX(70);
        lbl.setLayoutY(0);
        pane.getChildren().add(lbl);
        pane.getChildren().add(new Label(article[3]));
        return pane;
    }
}
