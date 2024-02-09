package Preference;

import Main.App;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Theme {
    private static final Stage mainStage = App.getMainStage();
    private static final Scene mainScene = mainStage.getScene();

    public static void setGruvboxDark() {
        mainScene.getStylesheets().clear();
        mainScene.setUserAgentStylesheet(null);
        mainScene.getStylesheets().add(Theme.class.getResource("GruvBoxDark.css").toExternalForm());
    }
    public static void setGruvBoxLight() {
        mainScene.getStylesheets().clear();
        mainScene.setUserAgentStylesheet(null);
        mainScene.getStylesheets().add(Theme.class.getResource("GruvBoxLight.css").toExternalForm());
    }
    public static void setNordDark() {
        mainScene.getStylesheets().clear();
        mainScene.setUserAgentStylesheet(null);
        mainScene.getStylesheets().add(Theme.class.getResource("NordDark.css").toExternalForm());
    }
    public static void setNordLight() {
        mainScene.getStylesheets().clear();
        mainScene.setUserAgentStylesheet(null);
        mainScene.getStylesheets().add(Theme.class.getResource("NordLight.css").toExternalForm());
    }
    public static void setSolarizedDark() {
        mainScene.getStylesheets().clear();
        mainScene.setUserAgentStylesheet(null);
        mainScene.getStylesheets().add(Theme.class.getResource("SolarizedDark.css").toExternalForm());
    }
    public static void setSolarizedLight() {
        mainScene.getStylesheets().clear();
        mainScene.setUserAgentStylesheet(null);
        mainScene.getStylesheets().add(Theme.class.getResource("SolarizedLight.css").toExternalForm());
    }

}
