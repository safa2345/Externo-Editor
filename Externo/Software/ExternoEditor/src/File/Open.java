package File;

import Component.EditorTab;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Open {
    private static final FileChooser fileChooser = new FileChooser();
    public static String file_path;

    public static void openFile() throws FileNotFoundException {

        fileChooser.setTitle("Open New Text");
        File file = fileChooser.showOpenDialog(new Stage());
        file_path = file.getAbsolutePath();

        Scanner scanner = new Scanner(file);
        String string = "";
        while (scanner.hasNextLine()) {
            string = string.concat(scanner.nextLine() + "\n");
        }
        EditorTab.addTab(file_path, string);
        OpenRecent.add(file.getAbsolutePath());
    }
    public static void openFile(File file) throws FileNotFoundException {
        file_path = file.getAbsolutePath();

        Scanner scanner = new Scanner(file);
        String string = "";
        while (scanner.hasNextLine()) {
            string = string.concat(scanner.nextLine() + "\n");
        }
        EditorTab.addTab(file_path, file.getName());
        OpenRecent.add(file.getAbsolutePath());

    }

    public static void setFile_path(String path) {
        file_path = path;
    }
    public static String getFile_path() {
        return file_path;
    }

}
