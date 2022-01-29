package client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Accueil extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("accueil.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("C:\\Users\\antho\\Documents\\Licence\\app répartie\\Projet_RMI_2021\\client\\src\\main\\resources\\hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Action lorsque que l'on clique sur le bouton d'un magasin
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void OnClickBtnMag(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("connexion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
