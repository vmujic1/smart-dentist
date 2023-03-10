package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MaterijaliManager;
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

    MaterijaliManager materijaliManager = new MaterijaliManager();

    public boolean daLiJeKolicinaBroj(String s){
        if(s.matches("[0-9]+")) return true;
        return false;
    }

    public boolean jeLiPrvaCifraNula(String s){
        if(s.charAt(0) == '0') return true;
        return false;
    }

    @FXML
    public void initialize() throws SmartDentistException {
        Materijali novi = new Materijali();
        novi = MaterijaliMainController.posalji();
        nazivId.setText(novi.getNaziv());
        kolicnaId.setText(String.valueOf(novi.getKoličina()));
    }
    public void urediOnClick(ActionEvent actionEvent) throws SmartDentistException {
        if(nazivId.getText().isEmpty() || kolicnaId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Popunite sve trazene podatke, a zatim pokusajte ponovo");
            alert.showAndWait();
        } else if(!daLiJeKolicinaBroj(kolicnaId.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Unijeli ste pogresnu kolicinu!");
            alert.showAndWait();


        } else if(jeLiPrvaCifraNula(kolicnaId.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Unijeli ste pogresnu kolicinu!");
            alert.showAndWait();

        }else if(Integer.parseInt(kolicnaId.getText()) < 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Unijeli ste pogresnu kolicinu!");
            alert.showAndWait();

        } else{
        Materijali novi = new Materijali();
        novi.setNaziv(nazivId.getText());
        novi.setKoličina(Integer.parseInt(kolicnaId.getText()));
        novi.setId(MaterijaliMainController.posalji().getId());
        MaterijaliManager.update(novi);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Uspjesno!");
        alert.setHeaderText(null);
        alert.setContentText("Uspjesno ste uredili stavku!");
        alert.showAndWait();
        Stage os = (Stage) nazivId.getScene().getWindow();
        os.close();
            openDialog("Skladiste materijala", "/fxml/materijali_main.fxml", null);}
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
        Stage os = (Stage) nazivId.getScene().getWindow();
        os.close();}
    }

