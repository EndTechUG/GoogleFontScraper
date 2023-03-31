package com.endtech.googlefontscraper;

import com.endtech.googlefontscraper.configuration.Properties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Logger;

public class Uninstaller {
    private static final Logger logger = Logger.getLogger(Uninstaller.class.getName());
    public static void main(String[] args) {
        File file = new File(Properties.FONTS_FILE);
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines){
                File font = new File(line);
                if (font.exists()){
                    if (!font.delete()) logger.severe(String.format("Could not delete file: %s", line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
