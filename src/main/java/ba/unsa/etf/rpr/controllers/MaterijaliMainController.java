package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MaterijaliManager;
import ba.unsa.etf.rpr.business.RasporedManager;
import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Date;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MaterijaliMainController {
    public TableView tabelaId;
    public TableColumn idKolonaId;
    public TableColumn imeKolonaId;

    public TextField pretragaId;
    public TableColumn kolicinaKolonaId;

    MaterijaliManager materijaliManager = new MaterijaliManager();

    @FXML
    public void initialize(){
        idKolonaId.setCellValueFactory(new PropertyValueFactory<Materijali,Integer>("id"));
        imeKolonaId.setCellValueFactory(new PropertyValueFactory<Materijali,String>("naziv"));
        kolicinaKolonaId.setCellValueFactory(new PropertyValueFactory<NarudzbePacijenata,String>("količina"));
        popuniTabelu();
    }

    private void popuniTabelu() {
        try{
            tabelaId.setItems(FXCollections.observableList(MaterijaliManager.getAll()));
            tabelaId.refresh();
        }catch (SmartDentistException e){
            new Alert(Alert.AlertType.NONE,e.getMessage(), ButtonType.OK);
        }
    }

    private void openDialog(String title, String file, Object controller){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
            loader.setController(controller);
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setTitle(title);
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
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
