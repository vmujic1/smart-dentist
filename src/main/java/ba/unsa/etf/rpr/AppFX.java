package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * Main class for JavaFX framework
 * extends Application class
 * @author vmujic1
 *
 */
public class AppFX extends Application {

    public static void main(String[] args) throws SmartDentistException {
        launch(args);

    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root  = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.setTitle("SmartDentist");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.getIcons().add(null);
        stage.setTitle("Prijava");
        stage.show();
    }

}

