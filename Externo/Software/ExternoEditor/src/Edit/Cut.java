package Edit;

import Component.EditorArea;
import Component.EditorTab;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class Cut {
    public static void cut() {
        EditorArea editorArea = EditorTab.getEditorArea();
        String text = editorArea.getSelectedText();
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
        editorArea.replaceText(editorArea.getText().replace(editorArea.getSelectedText(),""));
    }
}
