package client.controllers;

import client.MagasinInterface;
import client.Panier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class PageMagasinController {

    private Stage st;
    private int idpanier;
    private MagasinInterface magasin;

    @FXML
    Button btn_panier; // Bouton pour afficher le panier

    public PageMagasinController(){
    }

    public void setSt(Stage st) {
        this.st = st;
    }
    public void setIdpanier(int idpanier) {
        this.idpanier = idpanier;
    }


    // Pour afficher les articles dans 3 colonnes
    @FXML
    VBox vbox_art1,vbox_art2,vbox_art3;
    public void afficheArticles(ArrayList<String[]> listarticles){
        VBox[] vboxsart = new VBox[]{vbox_art1,vbox_art2,vbox_art3};
        int i = 0;

        for (String[] article : listarticles) {
            vboxsart[i%vboxsart.length].getChildren().add(miseEnPageArt(article));
            i++;
        }
    }

    // Modele pour mette en page les articles
    private Pane miseEnPageArt(String[] article){
        Pane pane = new Pane();
        pane.setMinHeight(180);

        // Nom de l'article
        Label lblNom = new Label(article[2]);
        lblNom.setLayoutX(0);
        lblNom.setLayoutY(105);

        // Déscription de l'article
        Label lblDesc = new Label(article[4]);
        lblDesc.setLayoutX(0);
        lblDesc.setLayoutY(120);

        // Prix de l'article
        Label lblprix = new Label(article[3]+"€");
        lblprix.setLayoutY(140);

        // Affiche l'image de l'article si il y en a une
        if(!article[1].equals("")) {
            Image image = new Image(article[1], 100, 100, true, true);
            ImageView imageView = new ImageView(image);
            imageView.setLayoutY(0);
            imageView.maxHeight(100);
            imageView.maxWidth(100);
            pane.getChildren().add(imageView);

        }

        // Bouton pour ajouter l'article au panier
        Button btnAddPanier = new Button("ajouter au panier");
        btnAddPanier.setLayoutY(50);
        btnAddPanier.setLayoutX(120);
        btnAddPanier.setOnAction(actionEvent -> {
            try {
                magasin.ajouteArticlePanier(idpanier,Integer.parseInt(article[0]));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        pane.getChildren().addAll(lblNom,lblDesc,lblprix,btnAddPanier);
        return pane;
    }

    public void setMagasin(MagasinInterface magasin) {
        this.magasin=magasin;
    }

    public void OnClickBtnPanier(ActionEvent actionEvent) {
        Panier panier = new Panier(st,magasin,idpanier); // Affichage du panier
    }
}
