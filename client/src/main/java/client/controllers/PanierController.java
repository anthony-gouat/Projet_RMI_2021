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
    private float total = 0; // Prix total du panier

    public PanierController(){
    }

    @FXML
    Button btn_commander;
    @FXML
    VBox vboxarticles,vboxtotal;
    public void afficheArticlesPanier(ArrayList<String[]> listarticles){
        // Affichage des articles dans le panier
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
        if(!(total >0)){
            btn_commander.setDisable(true);
        }

    }

    // Mise en page du recap
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

    // Modele de mise en forme de l'affichage des articles dans le panier
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

        //Bouton pour supprimer un article du panier
        Button suppArt = new Button("X");
        suppArt.setLayoutX(400);
        suppArt.setLayoutY(35);
        suppArt.setOnAction(actionEvent -> {
            try {
                magasin.setArticlePanier(idpanier,Integer.parseInt(article[0]),0); // Suppression de l'article
                Panier panier = new Panier(st,magasin,idpanier);// MAJ du panier
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
        SaisieDonnees saisieDonnees = new SaisieDonnees(st,magasin,total,idpanier); // Affichage de la page de saisie des données
    }

    public void RetourMag(ActionEvent actionEvent) {
        PageMagasin pgm = new PageMagasin(st,magasin,idpanier);// Retour à la page du magasin
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
}
