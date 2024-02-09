package File;

import java.io.File;
import java.io.IOException;

public class Save {

    private static String file_path = Open.getFile_path();
    public static void save () throws IOException {
        if(file_path == null)
            SaveAs.saveAs();
        else {
            File file = new File(file_path);
            SaveFile.saveFile(file);
        }
    }

}
