package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.RasporedManager;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class RasporedDodajController {
    public Button dodajId;
    public Button odustaniId;
    public TextField imeId;
    public TextField prezimeId;
    public TextField opisId;
    public DatePicker datumId;

    RasporedManager rasporedManager = new RasporedManager();

    public static boolean jeLiDatumPrijeDanasnjeg(LocalDate datum){
        if(datum.isBefore(LocalDate.now())) {
            return true;
        }
        return false;

    }

    public void dodajOnClick(ActionEvent actionEvent) throws SmartDentistException {
        if(imeId.getText().isEmpty() || prezimeId.getText().isEmpty() || opisId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Popunite sve trazene podatke, a zatim pokusajte ponovo");
            alert.showAndWait();
        }else if(jeLiDatumPrijeDanasnjeg(datumId.getValue())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska!");
            alert.setHeaderText(null);
            alert.setContentText("Neispravan datum.");
            alert.showAndWait();


        }else{
            NarudzbePacijenata nova = new NarudzbePacijenata();
            nova.setIme(imeId.getText());
            nova.setPrezime(prezimeId.getText());
            nova.setPovod(opisId.getText());
            nova.setDatum(datumId.getValue());
            RasporedManager.add(nova);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Uspjesno!");
            alert.setHeaderText(null);
            alert.setContentText("Uspjesno ste dodali novog pacijenta u raspored");
            alert.showAndWait();
            Stage os = (Stage) imeId.getScene().getWindow();
            os.close();
            openDialog("Skladiste materijala", "/fxml/raspored_main.fxml", null);
        }
    }

    public void odustaniOnClick(ActionEvent actionEvent) {
        Stage os = (Stage) imeId.getScene().getWindow();

        os.close();
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
}

