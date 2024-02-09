package Preference;

import Component.EditorArea;
import Component.EditorTab;
import javafx.scene.control.ScrollPane;
import org.fxmisc.flowless.VirtualizedScrollPane;

public class ScrollBar {
    private static final VirtualizedScrollPane<EditorArea> scrollPane = EditorTab.getScrollPane();

    public static void showAlways() {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    }

    public static void showNeeded() {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    public static void showNever() {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }
}
