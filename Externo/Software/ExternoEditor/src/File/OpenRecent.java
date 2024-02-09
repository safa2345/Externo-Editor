package File;

import javafx.scene.control.MenuItem;

import java.io.*;
import java.util.ArrayList;

public class OpenRecent {

    private static final ArrayList<String> recentFiles = new ArrayList();
    private static final String dataFile = "data/recent.txt";

    public static void add(String fileName) {

        if (fileName == null) return;

        for (String str : recentFiles)
            if (fileName.equals(str)) return;

        recentFiles.add("");
        for(int i=0; i < recentFiles.size()-1; ++i) {
            recentFiles.set(i+1, fileName);
        }
        recentFiles.set(0, fileName);

        MenuItem menuItem = new MenuItem(fileName);
        menuItem.setOnAction(e -> {
            try {
                Open.openFile(new File(fileName));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        FileMenu.open_recent.getItems().add(menuItem);
    }

    public static void readData() {

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {

            for (int i = 0; i < 5; i++) {

                String filename = reader.readLine();
                if (filename == null) return;
                OpenRecent.add(filename);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeData() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {

            for (String filename : recentFiles) {
                if (filename == null) return;
                writer.write(filename + "\n");
                System.out.println("wrote " + filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

