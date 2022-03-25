package client.controllers;

import client.MagasinInterface;
import client.PageMagasin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.*;


public class ConnexionController {

    private String nomMag; // nom du magasin

    private Stage st; // Stage utilisé pour l'affichage

    public ConnexionController(){
    }

    @FXML
    TextField txt_identifiant; // champ pour l'identifiant
    @FXML
    PasswordField txt_mdp; // champ pour le mdp
    @FXML
    Label lbl_mess_erreur; // Champ pour afficher les erreurs si il y en a

    /**
     * Action lors du clic sur le bouton connexion
     * @param actionEvent
     * @throws IOException
     * @throws NotBoundException
     */
    @FXML
    public void OnClickBtn(ActionEvent actionEvent) throws IOException, NotBoundException {
        // Récupération de l'interface magasin en RMI
        int port = 8800;
        MagasinInterface magasin1 = (MagasinInterface) Naming.lookup("rmi://127.0.0.1:" + port + "/"+nomMag);

        // récupération de l'identifiant et du mdp
        String identifiant = txt_identifiant.getText();
        String mdp = txt_mdp.getText();

        // Connexion au magasin qui retourne le panier de l'utilisateur
        int idpanier = magasin1.connexionClient(identifiant, mdp);

        if (idpanier>0) {
            // Affichage de la page du magasin
            PageMagasin pgm = new PageMagasin(st,magasin1,idpanier);
        } else { // si l'id de panier = 0 alorsproblème de connexion
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
