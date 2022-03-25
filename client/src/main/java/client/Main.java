package client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage st = new Stage();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        st.setScene(scene);
        st.show();
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
        Connexion co = new Connexion(st,((Control)actionEvent.getSource()).getId());
    }
}
