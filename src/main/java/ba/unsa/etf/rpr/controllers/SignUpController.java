package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

    public void registrujSeOnClick(ActionEvent actionEvent) throws SmartDentistException {
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
        Stage s = (Stage)adresaId.getScene().getWindow();
        s.close();


    }

    public void odustaniOnClick(MouseEvent mouseEvent) {
    }
}
