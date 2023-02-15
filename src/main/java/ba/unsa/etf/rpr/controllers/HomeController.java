package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class HomeController {
    public Button rasporedId;

    public void rasporedPacijenataOnClick(ActionEvent actionEvent) {
        Stage os = (Stage)rasporedId.getScene().getWindow();
        openDialog("Raspored pacijenata","/fxml/raspored_main.fxml",null);
        os.close();
    }

    public void skladisteMaterijalaOnClick(ActionEvent actionEvent) {
        Stage os = (Stage)rasporedId.getScene().getWindow();
        openDialog("Skladiste materijala", "/fxml/materijali_main.fxml",null);
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

    public void logOutOnClick(ActionEvent actionEvent) {
        Stage os = (Stage) rasporedId.getScene().getWindow();
        openDialog("Prijava","/fxml/login.fxml",null);
        os.close();

    }

    public void aboutOnClick(ActionEvent actionEvent) {
        Stage os = (Stage) rasporedId.getScene().getWindow();
        openDialog("O nama", "/fxml/about.fxml",null);

     }
}
