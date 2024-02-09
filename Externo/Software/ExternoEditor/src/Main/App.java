package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage mainStage;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SplashScreenUI.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Externo Editor");
        stage.setFullScreen(false);
        stage.show();

    }

    public static Stage getMainStage() {
        return mainStage;
    }
    public static Scene getScene() {
        return scene;
    }

    public static void main(String[] args) {
        Initializer.initializer();
        launch(args);
    }
}
