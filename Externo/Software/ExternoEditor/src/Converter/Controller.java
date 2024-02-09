package Converter;

import Main.App;
import Main.SplashScreen;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private TextField inputField;
    @FXML
    private TextField outputField;
    @FXML
    private ComboBox<String> format;

    private final FileChooser input_fileChooser = new FileChooser();
    private final FileChooser output_fileChooser = new FileChooser();
    private final Stage mainStage = App.getMainStage();
    private String file_path;
    private String output_path;
    private final ArrayList<String> arrayList = new ArrayList<>();
    private Boolean isPdf = false;
    private Boolean isEpub = false;
    private Boolean isDocx = false;
    private Boolean isOdt = false;
    private Boolean isHtml = false;
    private Boolean isMarkdown = false;
    private Boolean isFb2 = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        input_fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("Markdown Files (*.md)", "*.md"),
                new FileChooser.ExtensionFilter("Html Files (*.html)", "*.html"),
                new FileChooser.ExtensionFilter("Docx Files (*.docx)","*.docx"),
                new FileChooser.ExtensionFilter("Odt Files (*.odt)","*.odt"),
                new FileChooser.ExtensionFilter("Fb2 Files (*.fb2)","*.fb2"),
                new FileChooser.ExtensionFilter("Epub Files (*.epub)","*.epub"),
                new FileChooser.ExtensionFilter("Json Files (*.json)","*.json")
        );
        arrayList.add("PDF");
        arrayList.add("EPUB");
        arrayList.add("DOCX");
        arrayList.add("ODT");
        arrayList.add("HTML");
        arrayList.add("MARKDOWN");
        arrayList.add("FB2");
        format.getItems().addAll(arrayList);
    }
    @FXML
    public void onInput() {
        File input_file = input_fileChooser.showOpenDialog(mainStage);
        file_path = input_file.getAbsolutePath();
        inputField.setText(file_path);
    }
    @FXML
    public void onSelection() {
        int selectedIndex = format.getSelectionModel().getSelectedIndex();
        if(selectedIndex == 0)
            isPdf = true;
        else if(selectedIndex == 1)
            isEpub = true;
        else if(selectedIndex == 2)
            isDocx = true;
        else if(selectedIndex == 3)
            isOdt = true;
        else if(selectedIndex == 4)
            isHtml = true;
        else if(selectedIndex == 5)
            isMarkdown = true;
        else if(selectedIndex == 6)
            isFb2 = true;
    }
    @FXML
    public void onOutput() {
        if(isPdf) {
            output_fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Pdf Files (*.pdf)", "*.pdf")
            );
            isPdf = false;
        }
        if(isEpub) {
            output_fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Epub Files (*.epub)", "*.epub")
            );
            isEpub = false;
        }
        if(isDocx) {
            output_fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Docx Files (*.docx)","*.docx")
            );
            isDocx = false;
        }
        if(isOdt) {
            output_fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Odt Files (*.odt)","*.odt")
            );
            isOdt = false;
        }
        if(isHtml) {
            output_fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Html Files (*.html)", "*.html")
            );
            isHtml = false;
        }
        if(isMarkdown) {
            output_fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Markdown Files (*.md)", "*.md")
            );
            isMarkdown = false;
        }
        if(isFb2) {
            output_fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Fb2 Files (*.fb2)","*.fb2")
            );
            isFb2 = false;
        }
        File output_file = output_fileChooser.showSaveDialog(mainStage);
        output_path = output_file.getAbsolutePath();
        outputField.setText(output_path);
    }
    @FXML
    public void onBack() {
        Stage stage = App.getMainStage();
        Scene scene = SplashScreen.getScene();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onExit()
    {
        Platform.exit();
    }

    @FXML
    public void onConvert() {
        try {
            ArrayList<String> process = createCommand();
            Process pandoc = new ProcessBuilder(process).start();
            while (pandoc.isAlive())
            {
                System.out.println("loading");
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Congratulations! Document Conversation is Successful",ButtonType.OK
            );
            Stage stage = App.getMainStage();
            alert.setTitle("Confirm");
            alert.initOwner(stage);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                Platform.exit();
            }


        }catch (IOException ignored) {}
    }

    private ArrayList<String> createCommand() {
        ArrayList<String> command = new ArrayList<>();
        command.add("pandoc");
        command.add("-s");
        command.add(file_path);
        command.add("-o");
        command.add(output_path);
        return command;
    }

}
