package client.controllers;

import client.ClientInterface;
import client.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.rmi.Naming;

public class AccueilController {

    @FXML
    public void afficheMagasin() {

        boolean ping = pingMagasin("test");
        System.out.println(ping);
        if(ping) {
            Controller.changeScene("page_magasin.fxml");
        }
    }

    private boolean pingMagasin(String nom){
        try {
            int port = 8000;
            ClientInterface client = (ClientInterface) Naming.lookup("rmi://127.0.0.1:" + port + "/"+nom);
            return client!=null;
        } catch (Exception e) {
            System.out.println ("Banque exception: " + e);
        }
        return false;
    }
}
