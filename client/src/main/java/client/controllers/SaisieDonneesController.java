package client.controllers;

import client.MagasinInterface;
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

    public void NomChange(KeyEvent actionEvent) {
        System.out.println("NomChange");
        unlockValid();
    }

    public void NumChange(KeyEvent actionEvent) {
        System.out.println("NumChange");

        unlockValid();
    }

    public void DateChange(KeyEvent actionEvent) {
        System.out.println("DateChange");

        unlockValid();
    }

    public void CryptoChange(KeyEvent actionEvent) {
        System.out.println("CryptoChange");

        unlockValid();
    }

    public void Validation(ActionEvent actionEvent) {
        try {
            int res = magasin.passerCommande(txt_titulaire.getText(),txt_numero.getText(),txt_expiration.getText(),txt_cryptogramme.getText(),this.total);
            if (res==0){
                magasin.suppressionPanier(this.idpanier);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Commande");
                alert.setHeaderText("Cher client:");
                alert.setContentText("Merci d'avoir commandé chez nous !");

                alert.showAndWait();

            }
            System.out.println("res : "+res);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("validé");

    }

    public void Annulation(ActionEvent actionEvent) {
    }

    private void unlockValid(){
        if(!txt_titulaire.getText().equals("") && txt_numero.getText().length()==16 && txt_expiration.getText().length()==7 && txt_cryptogramme.getText().length()==3){
            btnValider.setDisable(false);
        }else{
            btnValider.setDisable(true);
        }
    }


    public void setIdPanier(int idpanier) {
        this.idpanier=idpanier;
    }
}
