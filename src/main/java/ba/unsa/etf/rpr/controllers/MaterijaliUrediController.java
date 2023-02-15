package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MaterijaliUrediController {
    public Button urediId;
    public Button odustaniId;
    public TextField nazivId;
    public TextField kolicnaId;

    @FXML
    public void initialize() throws SmartDentistException {
        Materijali novi = new Materijali();
        novi = MaterijaliMainController.posalji();
        nazivId.setText(novi.getNaziv());
        kolicnaId.setText(String.valueOf(novi.getKoličina()));
    }
    public void urediOnClick(ActionEvent actionEvent) throws SmartDentistException {
        Materijali novi = new Materijali();
        novi.setNaziv(nazivId.getText());
        novi.setKoličina(Integer.parseInt(kolicnaId.getText()));
        novi.setId(MaterijaliMainController.posalji().getId());
        DaoFactory.materijaliDao().update(novi);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Uspjesno!");
        alert.setHeaderText(null);
        alert.setContentText("Uspjesno ste uredili stavku!");
        alert.showAndWait();
        Stage os = (Stage) nazivId.getScene().getWindow();
        openDialog("Skladiste materijala", "/fxml/materijali_main.fxml", null);
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

    public void odustaniOnClick(ActionEvent actionEvent) {
    }
}