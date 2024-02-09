package Main;

import Component.EditorBox;
import Component.EditorTab;
import com.dansoftware.pdfdisplayer.PDFDisplayer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class Controller {

    private final Stage mainStage = App.getMainStage();

    @FXML
    public void onNew() {
        BorderPane borderPane = new BorderPane();
        HBox hBox = EditorBox.getUpBox();
        HBox hbox = EditorBox.getBottomBox();
        borderPane.setTop(hBox);
        borderPane.setCenter(EditorTab.getTabPane());
        borderPane.setBottom(hbox);
        Scene mainScene = new Scene(borderPane, 1000, 731);
        mainScene.getStylesheets().addAll(getClass().getResource("Default_theme.css").toExternalForm());
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    @FXML
    public void onOpen() throws IOException {
        FileChooser fileChooser = new FileChooser();
        Stage stage = App.getMainStage();
        File file = fileChooser.showOpenDialog(stage);
        fileChooser.setTitle("Open pdf file");
        if(file != null) {
            PDFDisplayer pdfDisplayer = new PDFDisplayer();
            pdfDisplayer.displayPdf(file);
            stage.setScene(new Scene(pdfDisplayer.toNode(),1000,731));
            stage.show();
        }
    }

    @FXML
    public void onConvert() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConverterUI.fxml"));
        Parent root = fxmlLoader.load();
        Scene mainScene = new Scene(root, 1000, 731);
        mainStage.setScene(mainScene);
        mainStage.show();

    }
}
