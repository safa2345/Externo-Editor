package Preference;

import Component.EditorArea;
import Component.EditorTab;

public class WordWrap {
    public static void enableWrap() {
        EditorArea editorArea = EditorTab.getEditorArea();
        editorArea.setWrapText(true);
    }
    public static void disableWrap() {
        EditorArea editorArea = EditorTab.getEditorArea();
        editorArea.setWrapText(false);
    }
}
