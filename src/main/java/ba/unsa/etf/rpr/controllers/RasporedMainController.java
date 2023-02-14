package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.RasporedManager;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    public void initialize(){
        idKolonaId.setCellValueFactory(new PropertyValueFactory<NarudzbePacijenata,Integer>("id"));
        imeKolonaId.setCellValueFactory(new PropertyValueFactory<NarudzbePacijenata,String>("ime"));
        prezimeKolonaId.setCellValueFactory(new PropertyValueFactory<NarudzbePacijenata,String>("prezime"));
        opisKolonaId.setCellValueFactory(new PropertyValueFactory<NarudzbePacijenata,String>("povod"));
        datumKolonaId.setCellValueFactory(new PropertyValueFactory<NarudzbePacijenata,Date>("datum"));
        popuniTabelu();
    }

    private void popuniTabelu() {
    }


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
