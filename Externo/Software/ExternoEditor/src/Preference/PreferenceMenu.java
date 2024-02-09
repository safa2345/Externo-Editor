package Preference;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class PreferenceMenu {

    private static final Menu preference = new Menu("Preferences");
    static {
        MenuItem increase_font = new MenuItem("Increase Font");
        increase_font.setOnAction(e -> Font.incFont());
        increase_font.setAccelerator(KeyCombination.keyCombination("CTRL+]"));

        MenuItem decrease_font = new MenuItem("Decrease Font");
        decrease_font.setOnAction(e -> Font.decFont());
        decrease_font.setAccelerator(KeyCombination.keyCombination("CTRL+["));

        Menu line_number = new Menu("Line Number");
        MenuItem enable = new MenuItem("Enable");
        enable.setOnAction(e -> LineNumber.enableLineNumber());
        MenuItem disable = new MenuItem("Disable");
        disable.setOnAction(e -> LineNumber.disableLineNumber());
        line_number.getItems().addAll(enable,disable);

        Menu wrap = new Menu("Word Wrap");
        MenuItem enable_wrap = new MenuItem("Enable");
        enable_wrap.setOnAction(e -> WordWrap.enableWrap());
        MenuItem disable_wrap = new MenuItem("Disable");
        disable_wrap.setOnAction(e -> WordWrap.disableWrap());
        wrap.getItems().addAll(enable_wrap,disable_wrap);

        MenuItem font = new MenuItem("Change Font and Size");
        font.setOnAction(e -> {
            try {
                (new Font()).start(new Stage());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        Menu theme = new Menu("Theme");
        MenuItem gruvbox_dark = new MenuItem("Gruvbox Dark");
        gruvbox_dark.setOnAction(e -> Theme.setGruvboxDark());
        MenuItem gruvbox_light = new MenuItem("Gruvbox Light");
        gruvbox_light.setOnAction(e -> Theme.setGruvBoxLight());
        MenuItem nord_dark = new MenuItem("Nord Dark");
        nord_dark.setOnAction(e -> Theme.setNordDark());
        MenuItem nord_light = new MenuItem("Nord Light");
        nord_light.setOnAction(e -> Theme.setNordLight());
        MenuItem solarized_dark = new MenuItem("Solarized Dark");
        solarized_dark.setOnAction(e -> Theme.setSolarizedDark());
        MenuItem solarized_light = new MenuItem("Solarized Light");
        solarized_light.setOnAction(e -> Theme.setSolarizedLight());
        theme.getItems().addAll(gruvbox_dark, gruvbox_light, nord_dark, nord_light, solarized_dark, solarized_light);

        Menu scroll_bar = new Menu("Scroll Bar");
        MenuItem show_always = new MenuItem("Show");
        show_always.setOnAction(e -> ScrollBar.showAlways());
        MenuItem show_needed = new MenuItem("Show only when needed");
        show_needed.setOnAction(e -> ScrollBar.showNeeded());
        MenuItem show_never = new MenuItem("Hide");
        show_never.setOnAction(e -> ScrollBar.showNever());

        scroll_bar.getItems().addAll(show_always,show_needed,show_never);
        preference.getItems().addAll(increase_font, decrease_font, font, new SeparatorMenuItem(), wrap, line_number, scroll_bar, new SeparatorMenuItem(), theme);
    }
    public static Menu getPreference(){
        return preference;
    }

}
