package com.grupogtd.test.utility;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class FileTool {
    public static int fileCountByExt(String path, String extension,Logger LOGGER)
    {
        int count = 0;
        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                files = listOfFile.getName();
                if (files.endsWith("." + extension.toLowerCase()) || files.endsWith("." + extension.toUpperCase())) {
                    count++;
                }
            }
        }
        LOGGER.log(Level.INFO,"{0} Archivos con extensión {1} en {2}", new Object[]{count, extension, path});
        return count;
    }
}
