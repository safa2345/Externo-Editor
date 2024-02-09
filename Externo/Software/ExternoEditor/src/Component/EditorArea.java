package Component;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;


public class EditorArea extends CodeArea {

    public EditorArea() {
        this.setWrapText(true);
        this.setParagraphGraphicFactory(LineNumberFactory.get(this));
    }
}