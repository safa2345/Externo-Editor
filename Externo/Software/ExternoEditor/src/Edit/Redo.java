package Edit;

import Component.EditorArea;
import Component.EditorTab;

public class Redo {
    public static void redo() {
        EditorArea editorArea = EditorTab.getEditorArea();
        if (editorArea.isRedoAvailable())
            editorArea.redo();
    }
}
