package client;

import client.Interface.MagasinInterface;
import client.controllers.ConnexionController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Connexion extends Application {

    private String nomMag = "mag1";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Connexion.class.getResource("connexion.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("C:\\Users\\antho\\Documents\\Licence\\app répartie\\Projet_RMI_2021\\client\\src\\main\\resources\\hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ConnexionController ctrl = (ConnexionController) fxmlLoader.getController();
        ctrl.setNomMag(nomMag);
        stage.setScene(scene);
        stage.show();
    }

    public Connexion() {}

    public Connexion(Stage stage,String nomMag) {
        this.nomMag = nomMag;
        System.out.println(nomMag);
        try {
            start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
