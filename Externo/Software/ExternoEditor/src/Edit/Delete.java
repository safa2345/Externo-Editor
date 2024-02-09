package Edit;

import Component.EditorArea;
import Component.EditorTab;


public class Delete {

    public static void delete() {
        EditorArea editorArea = EditorTab.getEditorArea();
        editorArea.replaceText(editorArea.getText().replace(editorArea.getSelectedText(),""));
    }
}
