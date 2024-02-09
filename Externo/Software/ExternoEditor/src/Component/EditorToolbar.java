package Component;

import Edit.*;
import File.*;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import java.io.FileNotFoundException;
import java.io.IOException;


public class EditorToolbar {
    private static final ToolBar toolBar;
    static {
        toolBar = new ToolBar();
        toolBar.setLayoutY(30);
        toolBar.setPrefHeight(30);
        toolBar.setPrefWidth(1000);

        Image new_image = new Image(EditorToolbar.class.getResource("tab.png").toExternalForm());
        Image open_image = new Image(EditorToolbar.class.getResource("open2.png").toExternalForm());
        Image save_image = new Image(EditorToolbar.class.getResource("save-as.png").toExternalForm());
        Image cut_image = new Image(EditorToolbar.class.getResource("cut-2.png").toExternalForm());
        Image copy_image = new Image(EditorToolbar.class.getResource("copy-2.png").toExternalForm());
        Image paste_image = new Image(EditorToolbar.class.getResource("paste.png").toExternalForm());
        Image find_image = new Image(EditorToolbar.class.getResource("find and replace.png").toExternalForm());
        Image undo_image = new Image(EditorToolbar.class.getResource("undo.png").toExternalForm());
        Image redo_image = new Image(EditorToolbar.class.getResource("redo.png").toExternalForm());

        MyButton new_b = new MyButton(new MyImageView(new_image));
        new_b.setOnAction(e -> New.newFile());
        MyButton open_b = new MyButton(new MyImageView(open_image));
        open_b.setOnAction(e -> {
            try {
                Open.openFile();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        MyButton save_b = new MyButton(new MyImageView(save_image));
        save_b.setOnAction(e -> {
            try {
                Save.save();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        MyButton cut_b = new MyButton(new MyImageView(cut_image));
        cut_b.setOnAction(e -> Cut.cut());
        MyButton copy_b = new MyButton(new MyImageView(copy_image));
        copy_b.setOnAction(e -> Copy.copy());
        MyButton paste_b = new MyButton(new MyImageView(paste_image));
        paste_b.setOnAction(e -> Paste.paste());
        MyButton find_b = new MyButton(new MyImageView(find_image));
        find_b.setOnAction(e -> FindAndReplace.findandreplace());
        MyButton undo_b = new MyButton(new MyImageView(undo_image));
        undo_b.setOnAction(e -> Undo.undo());
        MyButton redo_b = new MyButton(new MyImageView(redo_image));
        redo_b.setOnAction(e -> Redo.redo());

        toolBar.getItems().addAll(new_b, open_b, save_b, cut_b, copy_b, paste_b, find_b, undo_b, redo_b);
    }
    public static ToolBar getToolBar()
    {
        return toolBar;
    }
}
