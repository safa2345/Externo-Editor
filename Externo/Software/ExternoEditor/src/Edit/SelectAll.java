package Edit;

import Component.EditorArea;
import Component.EditorTab;

public class SelectAll {
    public static void selectAll() {
        EditorArea editorArea = EditorTab.getEditorArea();
        editorArea.selectAll();
    }
}
