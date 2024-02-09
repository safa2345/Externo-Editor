package Component;

import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.fxmisc.flowless.VirtualizedScrollPane;


public class EditorTab {
    private static final TabPane tabPane;
    private static Tab tab;
    private static EditorArea editorArea;
    private static VirtualizedScrollPane<EditorArea> scrollPane;
    static {
        tab = new Tab("Untitled");

        editorArea = new EditorArea();
        editorArea.setStyle("-fx-font-size: 15");

        scrollPane = new VirtualizedScrollPane<>(editorArea);
        scrollPane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);

        tab.setContent(scrollPane);
        tab.isClosable();
        tabPane = new TabPane();
        tabPane.getTabs().add(tab);
    }

    public static void addTab(String path) {
        String title;
        if(path == null) title = "Untitled";
        else title = path;
        tab = new Tab(title);
        editorArea = new EditorArea();
        scrollPane = new VirtualizedScrollPane<>(editorArea);
        scrollPane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        tab.setContent(scrollPane);
        tab.isClosable();
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);

    }
    public static void addTab(String path, String text) {
        tab = new Tab(path);
        editorArea = new EditorArea();
        editorArea.replaceText(text);
        tab.setContent(editorArea);
        tab.isClosable();
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);

    }
    public static TabPane getTabPane() {
        return tabPane;
    }
    public static Tab getTab() {
        return tab;
    }
    public static EditorArea getEditorArea(){
        return editorArea;
    }
    public static VirtualizedScrollPane<EditorArea> getScrollPane() {
        return scrollPane;
    }
}
