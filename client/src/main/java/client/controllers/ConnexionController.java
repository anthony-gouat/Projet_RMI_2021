package client.controllers;

import client.MagasinInterface;
import client.PageMagasin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.*;


public class ConnexionController {


    private String nomMag;

    private Stage st;

    public ConnexionController(){
    }

    @FXML
    TextField txt_identifiant;
    @FXML
    PasswordField txt_mdp;
    @FXML
    Label lbl_mess_erreur;

    /**
     * Action lors du clic sur le bouton connexion
     * @param actionEvent
     * @throws IOException
     * @throws NotBoundException
     */
    @FXML
    public void OnClickBtn(ActionEvent actionEvent) throws IOException, NotBoundException {
        int port = 8800;
        MagasinInterface magasin1 = (MagasinInterface) Naming.lookup("rmi://127.0.0.1:" + port + "/"+nomMag);
//        MagasinInterface magasin1 = (MagasinInterface) Naming.lookup("rmi://127.0.0.1:"+port+"/mag1");
        String identifiant = txt_identifiant.getText();
        String mdp = txt_mdp.getText();
        int idpanier = magasin1.connexionClient(identifiant, mdp);
        if (idpanier>0) {
            PageMagasin pgm = new PageMagasin(st,magasin1,idpanier);
        } else {
            lbl_mess_erreur.setText("Identifiant et/ou mot de passe incorect");
            lbl_mess_erreur.setStyle("-fx-color-label-visible: red");
        }
    }


    public void setSt(Stage st) {
        this.st = st;
    }

    public void setNomMag(String nomMag) {
        this.nomMag = nomMag;
    }
}
