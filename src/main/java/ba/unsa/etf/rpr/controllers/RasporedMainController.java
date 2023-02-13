package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RasporedMainController {
    public Button dodajId;
    public Button urediId;
    public Button obrisiId;

    public void dodajOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/raspored_dodaj.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();

    }

    public void urediOnClick(ActionEvent actionEvent) {
    }

    public void obrisiOnClick(ActionEvent actionEvent) {
    }
}
