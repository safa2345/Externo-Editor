package Edit;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;

public class EditMenu {
    private static final Menu edit = new Menu("Edit");
    static {
        MenuItem undo = new MenuItem("Undo");
        undo.setOnAction(e -> Undo.undo());
        undo.setAccelerator(KeyCombination.keyCombination("CTRL+Z"));

        MenuItem redo = new MenuItem("Redo");
        redo.setOnAction(e -> Redo.redo());
        redo.setAccelerator(KeyCombination.keyCombination("CTRL+SHIFT+Z"));

        MenuItem cut = new MenuItem("Cut");
        cut.setOnAction(e -> Cut.cut());
        cut.setAccelerator(KeyCombination.keyCombination("CTRL+X"));

        MenuItem copy = new MenuItem("Copy");
        copy.setOnAction(e -> Copy.copy());
        copy.setAccelerator(KeyCombination.keyCombination("CTRL+C"));

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> Paste.paste());
        paste.setAccelerator(KeyCombination.keyCombination("CTRL+V"));

        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction(e -> Delete.delete());
        delete.setAccelerator(KeyCombination.keyCombination("DELETE"));

        MenuItem find_and_replace = new MenuItem("Find and Replace");
        find_and_replace.setOnAction(e -> FindAndReplace.findandreplace());
        find_and_replace.setAccelerator(KeyCombination.keyCombination("CTRL+F"));

        MenuItem selectall = new MenuItem("Select All");
        selectall.setOnAction(e -> SelectAll.selectAll());
        selectall.setAccelerator(KeyCombination.keyCombination("CTRL+A"));

        edit.getItems().addAll(undo, redo, new SeparatorMenuItem(), cut, copy, paste, new SeparatorMenuItem(), selectall, delete, new SeparatorMenuItem(),find_and_replace);
    }
    public static Menu getEdit() {
        return edit;
    }
}
