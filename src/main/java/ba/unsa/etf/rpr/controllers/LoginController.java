package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class LoginController {


    public Button prijaviSeId;
    public Button registrujSeId;

    public void prijaviSeOnClick(ActionEvent actionEvent) throws IOException {
        Parent signUpParent = FXMLLoader.load(getClass().getResource("/fxml/raspored_main.fxml"));
        Scene signUpScene = new Scene(signUpParent);
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(signUpScene);
        stage.setResizable(false);
        stage.setTitle("Raspored");
        stage.show();

    }

    public void registrujSeOnClick(ActionEvent actionEvent) throws IOException {
        openDialog("Registracija","/fxml/signup.fxml",new SignUpController());

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
