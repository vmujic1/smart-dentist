package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.business.RasporedManager;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

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
    public RadioButton dnevniRasporedId;
    public RadioButton mjesecniRasporedId;
    public RadioButton cijeliRasporedId;

    RasporedManager rasporedManager = new RasporedManager();

    private ObservableList<NarudzbePacijenata> mjesecniPacijenti = FXCollections.observableArrayList();
    private ObservableList<NarudzbePacijenata> dnevniPacijenti = FXCollections.observableArrayList();
    private ObservableList<NarudzbePacijenata> sviPacijenti = FXCollections.observableArrayList();

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
        try{
            tabelaId.setItems(FXCollections.observableList(RasporedManager.getAll()));
            tabelaId.refresh();
        }catch (SmartDentistException e){
            new Alert(Alert.AlertType.NONE,e.getMessage(), ButtonType.OK);
        }
    }
    private void popuniTabeluDnevniSort(LocalDate date) {
        try{
            tabelaId.setItems(FXCollections.observableList(RasporedManager.getByDate(date)));
            tabelaId.refresh();
        }catch (SmartDentistException e){
            new Alert(Alert.AlertType.NONE,e.getMessage(), ButtonType.OK);
        }
    }


    public void dodajOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/raspored_dodaj.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
        popuniTabelu();

    }

    public void urediOnClick(ActionEvent actionEvent) {
    }

    public void obrisiOnClick(ActionEvent actionEvent) throws SmartDentistException {
        NarudzbePacijenata selected = (NarudzbePacijenata) tabelaId.getSelectionModel().getSelectedItem();
        if (selected != null) {
            RasporedManager.delete(selected.getId());
            popuniTabelu();
            Alert alet = new Alert(Alert.AlertType.INFORMATION);
            alet.setHeaderText(null);
            alet.setTitle("Uspjesno!");
            alet.setContentText("Uspjesno ste obrisali pacijenta iz rasporeda!");
            alet.showAndWait();
        } else{
            Alert alet = new Alert(Alert.AlertType.WARNING);
            alet.setHeaderText(null);
            alet.setTitle("Greska");
            alet.setContentText("Odaberite pacijenta iz rasporeda.");
            alet.showAndWait();

        }
    }

    public void dnevniRasporedOnAction(ActionEvent actionEvent) throws SmartDentistException {


            int danasnjiDatum = LocalDate.now().getDayOfMonth();
            Month trenutniMjesec = LocalDate.now().getMonth();
            List<NarudzbePacijenata> svi = RasporedManager.getAll();
            if (!dnevniPacijenti.isEmpty()) dnevniPacijenti.clear();

            for (NarudzbePacijenata n : svi) {
                if (n.getDatum().isEqual(LocalDate.now())) {
                    dnevniPacijenti.add(n);
                }
            }

            tabelaId.setItems(dnevniPacijenti);

    }

    public void mjesecniRasporedOnAction(ActionEvent actionEvent) throws SmartDentistException {


            Month trenutniMjesec = LocalDate.now().getMonth();
            List<NarudzbePacijenata> mjesecni = RasporedManager.getAll();

            if (!mjesecniPacijenti.isEmpty()) mjesecniPacijenti.clear();
            for (NarudzbePacijenata n : mjesecni) {
                if (n.getDatum().getMonth().equals(trenutniMjesec)) {
                    mjesecniPacijenti.add(n);
                }
            }

            tabelaId.setItems(mjesecniPacijenti);

    }
    public void cijeliRasporedOnAction(ActionEvent actionEvent) throws SmartDentistException {
        popuniTabelu();
        tabelaId.refresh();
    }

    public void odjaviSeOnClick(ActionEvent actionEvent) {
    }

    public void pregledMaterijalaOnClick(ActionEvent actionEvent) {
    }
}
