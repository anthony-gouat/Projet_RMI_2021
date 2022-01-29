package client;

import client.Interface.MagasinInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Connexion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("connexion.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("C:\\Users\\antho\\Documents\\Licence\\app répartie\\Projet_RMI_2021\\client\\src\\main\\resources\\hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
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
        int port = 8000;
        MagasinInterface magasin1 = (MagasinInterface) Naming.lookup("rmi://127.0.0.1:" + port + "/magasin1");
        String identifiant = txt_identifiant.getText();
        String mdp = txt_mdp.getText();
        if (magasin1.connexionClient(identifiant, mdp)) {
            //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("page_magasin.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            //Stage stage = new Stage();
            //stage.setScene(scene);
            //stage.show();
        } else {
            lbl_mess_erreur.setText("Identifiant et/ou mot de passe incorect");
            lbl_mess_erreur.setStyle("-fx-color-label-visible: red");
        }
    }
}
