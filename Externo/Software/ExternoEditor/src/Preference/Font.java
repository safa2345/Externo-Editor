package Preference;

import Component.EditorArea;
import Component.EditorTab;
import Main.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Font extends Application {
    private static Stage mainStage;
    private static int default_size = 15;
    private static final EditorArea editorArea = EditorTab.getEditorArea();

    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Theme.class.getResource("fontChooser.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Font Chooser");
        stage.show();
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void incFont() {
        default_size += 2;
        String size = String.valueOf(default_size);
        editorArea.setStyle("-fx-font-size: " + size);
    }

    public static void decFont() {
        default_size -= 2;
        String size = String.valueOf(default_size);
        editorArea.setStyle("-fx-font-size: " + size);
    }
}
