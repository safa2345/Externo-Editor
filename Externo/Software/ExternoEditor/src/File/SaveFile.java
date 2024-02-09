package File;

import Component.EditorArea;
import Component.EditorTab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveFile {
    public static void saveFile(File file) throws IOException {

        EditorArea editorArea = EditorTab.getEditorArea();
        PrintWriter savedText = new PrintWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(savedText);
        bufferedWriter.write(editorArea.getText());
        bufferedWriter.close();
    }
}
