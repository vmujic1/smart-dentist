package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class LoginController {


    public Button prijaviSeId;
    public Button registrujSeId;

    private final UserManager userManager = new UserManager();
    public TextField korisnickoImeID;
    public PasswordField lozinkaId;


    public void prijaviSeOnClick(ActionEvent actionEvent) throws IOException, SmartDentistException {



        try{
            User user = new User();
            user = userManager.getByUsername(korisnickoImeID.getText());
            if(lozinkaId.getText().equals(user.getLozinka())){
                openDialog("Home","/fxml/home.fxml",null);
                Stage os = (Stage) prijaviSeId.getScene().getWindow();
                os.close();
            } else if(korisnickoImeID.getText().isEmpty() || lozinkaId.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska!");
                alert.setContentText("Neispravno korisnicko ime ili lozinka!");
                alert.showAndWait();}
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Greska!");
                    alert.setHeaderText(null);
                    alert.setContentText("Neispravno korisnicko ime ili lozinka!");
                    alert.showAndWait();

                }
            }

        catch (SmartDentistException  e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska!");
            alert.setContentText("Neispravno korisnicko ime ili lozinka!");
            alert.showAndWait();


        }

    }

    public void registrujSeOnClick(ActionEvent actionEvent) throws IOException {
        openDialog("Registracija","/fxml/signup.fxml",null);

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
