package Preference;

import Component.EditorArea;
import Component.EditorTab;
import org.fxmisc.richtext.LineNumberFactory;

public class LineNumber {

    public static void enableLineNumber() {

        EditorArea editorArea = EditorTab.getEditorArea();
        editorArea.setParagraphGraphicFactory(LineNumberFactory.get(editorArea));
    }

    public static void disableLineNumber() {
        EditorArea editorArea = EditorTab.getEditorArea();
        editorArea.setParagraphGraphicFactory(null);
    }

}
