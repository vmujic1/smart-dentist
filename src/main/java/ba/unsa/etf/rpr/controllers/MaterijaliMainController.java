package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class MaterijaliMainController {
    public TableView tabelaId;
    public TableColumn idKolonaId;
    public TableColumn imeKolonaId;

    public TextField pretragaId;
    public TableColumn kolicinaKolonaId;

    @FXML
    public void initialize(){
        idKolonaId.setCellValueFactory(new PropertyValueFactory<Materijali,Integer>("id"));
        imeKolonaId.setCellValueFactory(new PropertyValueFactory<Materijali,String>("naziv"));
        kolicinaKolonaId.setCellValueFactory(new PropertyValueFactory<NarudzbePacijenata,String>("količina"));
        popuniTabelu();
    }



    public void dodajuTabeluOnAction(ActionEvent actionEvent) {
    }

    public void urediIzTabeleAction(ActionEvent actionEvent) {
    }

    public void obrisiIzTabeleAction(ActionEvent actionEvent) {
    }

    public void odjaviSeOnAction(ActionEvent actionEvent) {
    }

    public void rasporedPacijenataOnAction(ActionEvent actionEvent) {
    }
}
