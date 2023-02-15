package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MaterijaliManager;
import ba.unsa.etf.rpr.domain.Materijali;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MaterijaliMainController {
    public TableView tabelaId;
    public TableColumn idKolonaId;
    public TableColumn imeKolonaId;

    public TextField pretragaId;
    public TableColumn kolicinaKolonaId;

    public static Materijali materijal;

    public static MaterijaliManager materijaliManager = new MaterijaliManager();
    private ObservableList<Materijali> filtriranRezultat = FXCollections.observableArrayList();

    public static boolean daLiJeKolicinaIspravna(int m) throws SmartDentistException{
        if(m <= 0 ) return false;

        return true;
    }

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



    public void dodajuTabeluOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/materijali_dodaj.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
        tabelaId.refresh();
    }

    public static Materijali posalji() throws  SmartDentistException{
        return materijal;
    }

    public void urediIzTabeleAction(ActionEvent actionEvent) throws IOException {
        Materijali selected = (Materijali) tabelaId.getSelectionModel().getSelectedItem();
        materijal = selected;

        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("/fxml/materijali_ured.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();


        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
        popuniTabelu();
    }

    public void obrisiIzTabeleAction(ActionEvent actionEvent) throws SmartDentistException {
        Materijali selected = (Materijali) tabelaId.getSelectionModel().getSelectedItem();
        if (selected != null) {
            MaterijaliManager.delete(selected.getId());
            popuniTabelu();
            Alert alet = new Alert(Alert.AlertType.INFORMATION);
            alet.setHeaderText(null);
            alet.setTitle("Uspjesno!");
            alet.setContentText("Uspjesno ste obrisali stavku iz skladista!");
            alet.showAndWait();
        } else{
            Alert alet = new Alert(Alert.AlertType.WARNING);
            alet.setHeaderText(null);
            alet.setTitle("Greska");
            alet.setContentText("Odaberite stavku iz skladista.");
            alet.showAndWait();

        }
    }

    public void odjaviSeOnAction(ActionEvent actionEvent) {
        Stage os = (Stage) tabelaId.getScene().getWindow();
        openDialog("Prijava","/fxml/login.fxml",null);

        os.close();

    }

    public void rasporedPacijenataOnAction(ActionEvent actionEvent) {
        openDialog("Raspored","/fxml/raspored_main.fxml",null);
        Stage os = (Stage) tabelaId.getScene().getWindow();
        os.close();
    }


    public void onEnterPresed(KeyEvent keyEvent) throws SmartDentistException {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
        List<Materijali> svi = MaterijaliManager.getAll();
        if(!filtriranRezultat.isEmpty()) filtriranRezultat.clear();
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            for(Materijali m : svi){
                if(m.getNaziv().equals(pretragaId.getText()) )
                    filtriranRezultat.add(m);
            }
        }
        if(!pretragaId.getText().isEmpty()){

        tabelaId.setItems(filtriranRezultat);} else popuniTabelu();
    }}
}
