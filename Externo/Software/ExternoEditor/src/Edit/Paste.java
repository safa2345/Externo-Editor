package Edit;

import Component.EditorArea;
import Component.EditorTab;
import javafx.scene.input.Clipboard;

public class Paste {
    public static void paste() {
        EditorArea editorArea = EditorTab.getEditorArea();
        editorArea.paste();
        /*Clipboard systemClipboard = Clipboard.getSystemClipboard();
        String text = systemClipboard.getString();
        int caretPosition = editorArea.getCaretPosition();
        editorArea.insertText(caretPosition, text);*/
    }
}
