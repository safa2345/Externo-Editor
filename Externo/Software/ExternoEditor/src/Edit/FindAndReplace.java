package Edit;

import Component.EditorArea;
import Component.EditorBox;
import Component.EditorTab;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import org.fxmisc.richtext.model.Paragraph;


public class FindAndReplace {
    private static int lastFoundRow = 0;
    private static int lastFoundCol = -1;
    public static void findandreplace() {
        HBox hbox = EditorBox.getBottomBox();
        hbox.prefHeight(90);
        hbox.prefWidth(1000);
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(90);
        anchorPane.setPrefWidth(1000);
        TextField findField = new TextField();
        findField.setLayoutX(22);
        findField.setLayoutY(14);
        TextField replaceField = new TextField();
        replaceField.setLayoutX(22);
        replaceField.setLayoutY(50);

        Button next = new Button("Find Next");
        next.setLayoutX(199);
        next.setLayoutY(14);
        Button prev = new Button("Find prev");
        prev.setLayoutX(289);
        prev.setLayoutY(15);
        Button replace = new Button("Replace Selected");
        replace.setLayoutX(199);
        replace.setLayoutY(50);
        Button replaceAll = new Button("Replace All");
        replaceAll.setLayoutX(340);
        replaceAll.setLayoutY(50);

        Button close = new Button("Close");
        close.setLayoutX(22);
        close.setLayoutY(80);


        anchorPane.getChildren().addAll(findField,next,prev,replaceField,replace,replaceAll,close);
        hbox.getChildren().add(anchorPane);

        close.setOnAction(e -> {
            hbox.getChildren().remove(anchorPane);
            hbox.setPrefHeight(30);
            hbox.setPrefWidth(1000);
        });

        next.setOnAction(e -> {
            EditorArea editorArea = EditorTab.getEditorArea();
            String findText = findField.getText();

            int startRow = lastFoundRow, startCol = lastFoundCol + 1;
            int totalRows = editorArea.getParagraphs().size();

            for(int i=0; i<=totalRows; ++i) {
                if(startRow >= totalRows) {
                    startRow = 0;
                    startCol = 0;
                }

                Paragraph paragraph = editorArea.getParagraph(startRow);
                String text = paragraph.getText();
                if (text.indexOf(findText, startCol) != -1) {

                    int startPos = editorArea.position(startRow, text.indexOf(findText, startCol)).toOffset();
                    editorArea.selectRange(startPos, startPos + findText.length());
                    if (text.indexOf(findText, startCol) + findText.length() >= paragraph.length()) {
                        lastFoundCol = -1;
                        lastFoundRow = startRow + 1;
                    } else {
                        lastFoundRow = startRow;
                        lastFoundCol = text.indexOf(findText, startCol);
                    }
                    break;
                }
                startCol = 0;
                startRow += 1;
            }
        });
        prev.setOnAction(e -> {

            EditorArea editorArea = EditorTab.getEditorArea();
            String findText = findField.getText();

            int startRow = lastFoundRow, startCol = lastFoundCol - 1;
            int totalRows = editorArea.getParagraphs().size();
            for (int i=0; i<=totalRows; ++i) {
                if(startCol < 0) {
                    startRow--;
                    if(startRow < 0) startRow = totalRows - 1;
                    startCol = editorArea.getParagraph(startRow).length() - 1;
                }

                String text = editorArea.getParagraph(startRow).getText();
                if (text.lastIndexOf(findText, startCol) != -1) {

                    int startPos = editorArea.position(startRow, text.lastIndexOf(findText, startCol)).toOffset();
                    editorArea.selectRange(startPos, startPos + findText.length());

                    lastFoundRow = startRow;
                    lastFoundCol = text.lastIndexOf(findText, startCol);
                    break;
                }

                startRow--;
                if (startRow < 0) startRow = totalRows - 1;
                if (startRow >= 0) startCol = editorArea.getParagraph(startRow).length() - 1;
            }
        });
        replace.setOnAction(e -> {

            if (replaceField.getText() == null || findField.getText() == null) return;

            EditorArea editorArea = EditorTab.getEditorArea();
            if (editorArea.getSelection().getLength() == findField.getText().length())
                editorArea.replaceSelection(replaceField.getText());
        });
        replaceAll.setOnAction(e -> {
            EditorArea editorArea = EditorTab.getEditorArea();
            if (findField.getText() == null)
                return;

            String replacedText = editorArea.getText();
            replacedText = replacedText.replaceAll(findField.getText(), replaceField.getText());
            editorArea.selectAll();
            editorArea.replaceSelection(replacedText);
        });
    }
}

