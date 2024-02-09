package Component;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class EditorBox {
    private static final HBox hBox;
    private static final HBox hbox;
    static {
        hBox = new HBox();
        hBox.setPrefWidth(1000);
        hBox.setPrefHeight(30);
        hBox.setId("hbox-custom");

        hbox = new HBox();
        hbox.setPrefWidth(1000);
        hbox.prefHeight(60);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(1000);
        anchorPane.setPrefHeight(60);

        anchorPane.getChildren().addAll(EditorMenu.getMenuBar(),EditorToolbar.getToolBar());
        hbox.getChildren().add(anchorPane);
    }
    public static HBox getUpBox() {
        return hbox;
    }
    public static HBox getBottomBox() {
        return hBox;
    }
}
