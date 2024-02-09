package Edit;

import Component.EditorArea;
import Component.EditorTab;

public class Undo {
    public static void undo() {
        EditorArea editorArea = EditorTab.getEditorArea();
        if (editorArea.isUndoAvailable())
            editorArea.undo();
    }

}
