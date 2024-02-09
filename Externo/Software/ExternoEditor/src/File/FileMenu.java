package File;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileMenu {
    private static final Menu file = new Menu("File");
    public static Menu open_recent;
    static {
        MenuItem new_file = new MenuItem("New");
        new_file.setOnAction(e -> New.newFile());
        new_file.setAccelerator(KeyCombination.keyCombination("CTRL+N"));

        MenuItem open_file = new MenuItem("Open");
        open_file.setOnAction(e -> {
            try {
                Open.openFile();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        open_file.setAccelerator(KeyCombination.keyCombination("CTRL+O"));

        open_recent = new Menu("Open Recent...");

        MenuItem save_file = new MenuItem("Save");
        save_file.setOnAction(e -> {
            try {
                Save.save();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        save_file.setAccelerator(KeyCombination.keyCombination("CTRL+S"));

        MenuItem save_file_as = new MenuItem("Save As");
        save_file_as.setOnAction(e -> {
            try {
                SaveAs.saveAs();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        save_file_as.setAccelerator(KeyCombination.keyCombination("CTRL+SHIFT+S"));

        MenuItem back = new MenuItem("Back to Main Menu");
        back.setOnAction(e -> Back.backtoMain());
        back.setAccelerator(KeyCombination.keyCombination("CTRL+B"));


        MenuItem exit_file = new MenuItem("Exit");
        exit_file.setOnAction(e -> Exit.exit());
        exit_file.setAccelerator(KeyCombination.keyCombination("CTRL+W"));

        file.getItems().addAll(new_file, new SeparatorMenuItem(), open_file, open_recent, new SeparatorMenuItem(), save_file, save_file_as, new SeparatorMenuItem(),back, exit_file);

    }
    public static Menu getFile() {
        return file;
    }
}
