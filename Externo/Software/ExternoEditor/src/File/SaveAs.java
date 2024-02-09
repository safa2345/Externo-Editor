package File;

import Component.EditorTab;
import javafx.scene.control.Tab;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SaveAs {
    public static void saveAs() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(new Stage());
        SaveFile.saveFile(file);
        Open.setFile_path(file.getAbsolutePath());
        Tab tab = EditorTab.getTab();
        tab.setText(file.getName());
    }
}
