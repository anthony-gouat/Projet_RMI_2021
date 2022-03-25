package client.controllers;

import client.MagasinInterface;
import client.PageMagasin;
import client.Panier;
import client.SaisieDonnees;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class PanierController {
    private Stage st;
    private int idpanier;
    private MagasinInterface magasin;
    private float total = 0;
    public PanierController(){
    }

    public void setSt(Stage st) {
        this.st = st;
    }

    public void setIdpanier(int idpanier) {
        this.idpanier = idpanier;
    }

    public void setMagasin(MagasinInterface magasin) {
        this.magasin=magasin;
    }

    @FXML
    Button btn_commander;
    @FXML
    VBox vboxarticles,vboxtotal;
    public void afficheArticlesPanier(ArrayList<String[]> listarticles){
        for (String[] article : listarticles) {
            vboxarticles.getChildren().add(miseEnPageArt(article));
            vboxtotal.getChildren().add(miseEnPageTotal(article));
        }
        Pane pane = new Pane();
        Label lbltotal = new Label("Total : "+ total +"€");
        lbltotal.setMaxWidth(Double.MAX_VALUE);

        lbltotal.setAlignment(Pos.CENTER);
        pane.getChildren().add(lbltotal);
        vboxtotal.getChildren().add(pane);
        System.out.println(total);
        if(!(total >0)){
            btn_commander.setDisable(true);
        }

    }


    private Pane miseEnPageTotal(String[] article){
        Pane pane = new Pane();
        Float prix = Float.parseFloat(article[3])*Integer.parseInt(article[7]);
        total+=prix;
        Label lblprix = new Label(prix+"€");
        lblprix.setMaxWidth(Double.MAX_VALUE);
        lblprix.setAlignment(Pos.CENTER);
        pane.getChildren().add(lblprix);
        return pane;
    }

    private Pane miseEnPageArt(String[] article){
        Pane pane = new Pane();
        pane.setMinHeight(180);

        Label lblNom = new Label(article[2]);
        lblNom.setLayoutX(110);
        lblNom.setLayoutY(35);

        Label lblprix = new Label(article[3]+"€");
        lblprix.setLayoutX(240);
        lblprix.setLayoutY(35);

        Label lblqte = new Label("Quantité : "+article[7]);
        lblqte.setLayoutX(300);
        lblqte.setLayoutY(35);

        Button suppArt = new Button("X");
        lblqte.setLayoutX(350);
        lblqte.setLayoutY(35);
        suppArt.setOnAction(actionEvent -> {
            try {
                magasin.setArticlePanier(idpanier,Integer.parseInt(article[0]),0);
                Panier panier = new Panier(st,magasin,idpanier);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        if(!article[1].equals("")) {
            Image image = new Image(article[1], 100, 100, true, true);
            ImageView imageView = new ImageView(image);
            imageView.setLayoutY(0);
            imageView.maxHeight(100);
            imageView.maxWidth(100);
            pane.getChildren().add(imageView);
        }

        pane.getChildren().addAll(lblNom,lblqte,lblprix,suppArt);
        return pane;
    }


    public void OnClickBtnCommander(ActionEvent actionEvent) {
        SaisieDonnees saisieDonnees = new SaisieDonnees(st,magasin,total,idpanier);
    }

    public void RetourMag(ActionEvent actionEvent) {
        PageMagasin pgm = new PageMagasin(st,magasin,idpanier);
    }
}
