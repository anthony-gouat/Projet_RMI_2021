package client.controllers;

import client.MagasinInterface;
import client.Panier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.rmi.RemoteException;

public class SaisieDonneesController {
    // Informations de la carte bancaire
    public Button btnValider;
    public TextField txt_titulaire;
    public TextField txt_numero;
    public TextField txt_expiration;
    public PasswordField txt_cryptogramme;

    private Stage st;
    private int idpanier;
    private MagasinInterface magasin;
    private float total = 0;

    public SaisieDonneesController(){
    }

    @FXML
    VBox vboxrecap;
    public void afficheArticles(){
        // Recap du prix
        Pane pane = new Pane();
        Label lbltotal = new Label("Total : "+ total +"€");
        lbltotal.setMaxWidth(Double.MAX_VALUE);
        lbltotal.setAlignment(Pos.CENTER);
        pane.getChildren().add(lbltotal);
        vboxrecap.getChildren().add(pane);
    }

    // Quand un champ d'un info bancaire change
    public void NomChange(KeyEvent actionEvent) {
        unlockValid();
    }

    public void NumChange(KeyEvent actionEvent) {
        unlockValid();
    }

    public void DateChange(KeyEvent actionEvent) {
        unlockValid();
    }

    public void CryptoChange(KeyEvent actionEvent) {
        unlockValid();
    }

    // Validation du paiement
    public void Validation(ActionEvent actionEvent) {
        try {
            // Commande au magasin
            int res = magasin.passerCommande(txt_titulaire.getText(),txt_numero.getText(),txt_expiration.getText(),txt_cryptogramme.getText(),this.total);
            // 0 = pas d'erreurs (Informations,solde)
            if (res==0){
                // On vide le panier
                magasin.suppressionPanier(this.idpanier);

                // Affichage du remerciement
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Commande");
                alert.setHeaderText("Cher client:");
                alert.setContentText("Merci d'avoir commandé chez nous !");
                alert.showAndWait();

            }else if(res==1){

                // Affichage d'une erreur
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Commande");
                alert.setHeaderText("Cher client:");
                alert.setContentText("Vos informations bancaires sont érronnés \nou votre solde est insuffisant");
                alert.showAndWait();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    // Retour au panier
    public void Annulation(ActionEvent actionEvent) {
        Panier panier = new Panier(st,magasin,idpanier);
    }

    // Active le bouton des commandes si toutes les informations bancaires sont entrées
    private void unlockValid(){
        if(!txt_titulaire.getText().equals("") && txt_numero.getText().length()==16 && txt_expiration.getText().length()==7 && txt_cryptogramme.getText().length()==3){
            btnValider.setDisable(false);
        }else{
            btnValider.setDisable(true);
        }
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

    public void setIdPanier(int idpanier) {
        this.idpanier=idpanier;
    }
}
