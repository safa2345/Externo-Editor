package File;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Exit {
    public static void exit() {
        Platform.exit();
        /*Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.showAndWait();

        Optional<ButtonType> rslt = alert.showAndWait();
        if (rslt.isPresent() && rslt.get() == ButtonType.OK)
            Platform.exit();*/
    }
}
