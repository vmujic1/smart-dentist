package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MaterijaliManager;
import ba.unsa.etf.rpr.business.RasporedManager;
import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MaterijaliDodajController {

    public Button dodajId;
    public Button odustaniId;
    public TextField nazivId;
    public TextField kolicnaId;

    MaterijaliManager materijaliManager = new MaterijaliManager();

    public void dodajOnClick(ActionEvent actionEvent) throws SmartDentistException {
        if(nazivId.getText().isEmpty() || kolicnaId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Popunite sve trazene podatke, a zatim pokusajte ponovo");
            alert.showAndWait();
        }else if(Integer.parseInt(kolicnaId.getText()  ) <= 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Unijeli ste kolicinu manju od 0.");
            alert.showAndWait();

        }else{
            Materijali novi = new Materijali();
            novi.setNaziv(nazivId.getText());
            novi.setKoličina(Integer.parseInt(kolicnaId.getText()));
            MaterijaliManager.add(novi);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Uspjesno!");
            alert.setHeaderText(null);
            alert.setContentText("Uspjesno ste dodali novu stavku u skladiste!");
            alert.showAndWait();
            Stage os = (Stage) nazivId.getScene().getWindow();
            openDialog("Pregled materijala", "/fxml/materijali_main.fxml", null);
            os.close();
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

    public void odustaniOnClick(ActionEvent actionEvent) {
    }
}
