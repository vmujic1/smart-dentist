package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.RasporedManager;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class RasporedMainController {
    public Button dodajId;
    public Button urediId;
    public Button obrisiId;
    public TableView<NarudzbePacijenata> tabelaId;
    public TableColumn<NarudzbePacijenata, Integer> idKolonaId;
    public TableColumn<NarudzbePacijenata,String> imeKolonaId;
    public TableColumn<NarudzbePacijenata,String> prezimeKolonaId;
    public TableColumn<NarudzbePacijenata, String> opisKolonaId;
    public TableColumn<NarudzbePacijenata, Date> datumKolonaId;

    RasporedManager rasporedManager = new RasporedManager();

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
