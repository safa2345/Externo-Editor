package Preference;

import Component.EditorArea;
import Component.EditorTab;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class fontChooser {
    @FXML
    private TextField namefield;
    @FXML
    private TextField sizefield;
    @FXML
    private CheckBox IsBold;
    @FXML
    private CheckBox IsItalic;
    private EditorArea editorArea;

    @FXML
    public void onApply() {
        DefaultData.setFontFace(namefield.getText());
        DefaultData.setFontSize(Integer.parseInt(sizefield.getText()));
        DefaultData.setBoldFont(IsBold.isSelected());
        DefaultData.setItalicFont(IsItalic.isSelected());

        editorArea = EditorTab.getEditorArea();
        editorArea.setStyle(DefaultData.getFontStyle());
        Stage stage = Font.getMainStage();
        stage.close();
    }
    @FXML
    public void onExit() {
        Platform.exit();
    }
}
