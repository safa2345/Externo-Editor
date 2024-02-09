package Preference;

public class DefaultData {
    private static String fontFace = "Fira Mono";
    private static int fontSize = 15;
    private static boolean boldFont = true;
    private static boolean italicFont = true;


    public static void setFontFace(String fontFace) {
        DefaultData.fontFace = fontFace;
    }
    public static void setFontSize(int fontSize) {
        DefaultData.fontSize = fontSize;
    }

    public static boolean isBoldFont() {
        return boldFont;
    }

    public static void setBoldFont(boolean boldFont) {
        DefaultData.boldFont = boldFont;
    }

    public static boolean isItalicFont() {
        return italicFont;
    }

    public static void setItalicFont(boolean italicFont) {
        DefaultData.italicFont = italicFont;
    }

    public static String getFontStyle() {
        return String.format("-fx-font-family: %s; -fx-font-size: %spx;%s%s", fontFace, fontSize,
                (DefaultData.isBoldFont() ? " -fx-font-weight: bold; " : ""),
                (DefaultData.isItalicFont() ? " -fx-font-style: italic; " : ""));
    }

}
