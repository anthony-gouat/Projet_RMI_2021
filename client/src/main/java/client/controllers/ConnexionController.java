package client.controllers;

import client.Interface.MagasinInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class ConnexionController {


    private String nomMag;

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
        System.out.println(nomMag);

//        MagasinInterface magasin1 = (MagasinInterface) Naming.lookup("rmi://127.0.0.1:" + port + "/"+nomMag);
        MagasinInterface magasin1 = (MagasinInterface) Naming.lookup("rmi://127.0.0.1:"+port+"/mag1");
        String identifiant = txt_identifiant.getText();
        String mdp = txt_mdp.getText();
        if (magasin1.connexionClient(identifiant, mdp)) {
            //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("page_magasin.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            //Stage stage = new Stage();
            //stage.setScene(scene);
            //stage.show();
            System.out.println("ok");
        } else {
            lbl_mess_erreur.setText("Identifiant et/ou mot de passe incorect");
            lbl_mess_erreur.setStyle("-fx-color-label-visible: red");
        }
    }

    public void setNomMag(String nomMag) {
        this.nomMag = nomMag;
    }
}
