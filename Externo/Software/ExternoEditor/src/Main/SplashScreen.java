package Main;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SplashScreen extends Thread{
    private static Scene scene;
    public void run() {
        try {
            Stage stage = App.getMainStage();
            Thread.sleep(6500);
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AppUI.fxml"));
                    Parent root = null;
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("ButtonStyle.css").toExternalForm());
                    stage.setScene(scene);
                    stage.setTitle("Externo Editor");
                    stage.setFullScreen(false);
                    stage.show();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static Scene getScene() {
        return scene;
    }
}
