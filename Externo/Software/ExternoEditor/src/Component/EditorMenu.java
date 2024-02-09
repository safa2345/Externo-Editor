package Component;


import About.About;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class EditorMenu {
    private static final MenuBar menuBar = new MenuBar();
    static {
        Menu help = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(e -> {
            try {
                new About().start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        help.getItems().add(about);
        menuBar.setPrefWidth(1000);
        menuBar.getMenus().addAll(File.FileMenu.getFile(), Edit.EditMenu.getEdit(), Preference.PreferenceMenu.getPreference(),help);
    }

    public static MenuBar getMenuBar() {
        return menuBar;
    }
}

