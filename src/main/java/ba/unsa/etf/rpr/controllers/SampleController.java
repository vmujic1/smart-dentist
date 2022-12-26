package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SampleController {
    public Button okDugmeID;
    public TextField usernameid;
    public PasswordField passwordid;
    public Button cancelID;

    public void okDugmeAkcija(ActionEvent actionEvent) {
        if(usernameid.getCharacters().length() == 0 || passwordid.getText().length() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setContentText("Niste unijeli username i/ili password");
            alert.show();
        } else {
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Success");
            alert1.setHeaderText("Uspjesno ste unijeli username i password!");
            alert1.show();
        }

    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage)cancelID.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Da li zelite zatvoriti prozor?");
        alert.showAndWait();

        stage.close();
}}
