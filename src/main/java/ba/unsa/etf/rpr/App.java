package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.Dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * author Vedran Mujic
 *
 */
public class App extends Application {

    public static void main(String[] args) throws SmartDentistException {
        launch(args);

    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root  = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.setTitle("SmartDentist");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.setTitle("Prijava");
        stage.show();
    }

}

