package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class SignUpController {
    private final UserManager userManager = new UserManager();
    public Button registrujSeId;
    public VBox odustaniId;
    public TextField korisnickoImeId;
    public TextField lozinkaId;
    public TextField nazivOrdinacijeId;
    public TextField brojZaposlenihId;
    public TextField adresaId;
    public TextField emailId;
    public TextField kontaktTelefonId;
    public TextField brojPoslovnicaId;

    List<User> users = DaoFactory.userDao().getAll();

    public SignUpController() throws SmartDentistException {
    }

    public void registrujSeOnClick(ActionEvent actionEvent) throws SmartDentistException {
        if(korisnickoImeId.getText().isEmpty() || lozinkaId.getText().isEmpty() || nazivOrdinacijeId.getText().isEmpty() || brojZaposlenihId.getText().isEmpty() || adresaId.getText().isEmpty() || emailId.getText().isEmpty() || kontaktTelefonId.getText().isEmpty() || brojZaposlenihId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText("Pogresni podaci!");
            alert.setContentText("Popunite sva trazena polja.");
            alert.showAndWait();
        }

        boolean istoKorisnicko = false;
        boolean istiNazivOrdinacije = false;

        for(User useri : users){
            if(useri.getUsername().equals(korisnickoImeId.getText())){
                istoKorisnicko = true;
                break;
            } else if(useri.getImeOrdinacije().equals(nazivOrdinacijeId.getText())){
                istiNazivOrdinacije = true;
                break;
            }
        }

        if(istoKorisnicko){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText("Pogresni podaci!");
            alert.setContentText("Korisnicko ime vec u upotrebi.");
            alert.showAndWait();

        } else if(istiNazivOrdinacije){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText("Pogresni podaci!");
            alert.setContentText("Ordinacija je već registrovana na nasu aplikaciju.");
            alert.showAndWait();
        } else if(lozinkaId.getText().length() < 5){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText("Pogresni podaci!");
            alert.setContentText("Lozinka mora sadrzavati vise od 5 karaktera.");
            alert.showAndWait();
        } else {

            User u = new User();
            u.setUsername(korisnickoImeId.getText());
            u.setLozinka(lozinkaId.getText());
            u.setImeOrdinacije(nazivOrdinacijeId.getText());
            u.setBroj_zaposlenih(brojZaposlenihId.getText());
            u.setAdresa(adresaId.getText());
            u.setEmail(emailId.getText());
            u.setKontakt_telefon(kontaktTelefonId.getText());
            u.setBroj_poslovnica(brojPoslovnicaId.getText());
            userManager.add(u);
            Node n = (Node) actionEvent.getSource();
            Stage stage = (Stage) n.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            alert.setHeaderText(null);
            alert.setContentText("Your account has been created. You can now log in.");
            alert.showAndWait();
            stage.close();
            openDialog("Prijava","/fxml/login.fxml",null);

        }
    }

    public void odustaniOnClick(MouseEvent mouseEvent) {
        Stage s = (Stage)kontaktTelefonId.getScene().getWindow();
        openDialog("Prijava","/fxml/login.fxml",null);
        s.close();
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

    public void odustaniOnAction(ActionEvent actionEvent) {
        Stage s = (Stage)kontaktTelefonId.getScene().getWindow();
        openDialog("Prijava","/fxml/login.fxml",null);
        s.close();
    }
}
