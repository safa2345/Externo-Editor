package File;

import Main.App;
import Main.SplashScreen;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Back {
    public static void backtoMain() {
        Stage stage = App.getMainStage();
        Scene scene = SplashScreen.getScene();
        stage.setScene(scene);
        stage.show();
    }
}
