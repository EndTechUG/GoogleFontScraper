package com.endtech.googlefontscraper.processor;

import com.endtech.googlefontscraper.configuration.ConfigurationHelper;
import com.endtech.googlefontscraper.configuration.Properties;
import com.endtech.googlefontscraper.googlefonts.dtos.GoogleFontDTO;
import com.endtech.googlefontscraper.googlefonts.dtos.GoogleFontFilesDTO;
import com.endtech.googlefontscraper.googlefonts.dtos.GoogleFontsResponseDTO;
import com.github.pireba.applescript.AppleScript;
import com.github.pireba.applescript.AppleScriptException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class FontProcessor {
    private static final Logger logger = Logger.getLogger(FontProcessor.class.getName());
    public static void process(GoogleFontsResponseDTO response){
        List<GoogleFontDTO> fonts = response.getItems();
        List<String> urls = new ArrayList<>();
        for (GoogleFontDTO font : fonts){
            for (Field f : GoogleFontFilesDTO.class.getDeclaredFields()){
                try {
                    if (!f.isAccessible()){
                        f.setAccessible(true);
                    }
                    Object obj = f.get(font.getFiles());
                    if (obj == null) continue;
                    String v = String.valueOf(f.get(font.getFiles()));
                    urls.add(v);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        List<String> installed = new ArrayList<>();
        int count = 0;
        for (String url : urls){
            String local = createLocalName(url);
            downloadAndSaveFile(url, local);
            installed.add(url);
            logger.info(String.format("%d/%d", ++count, urls.size()));
            if (count == 50) return;
        }
        saveWroteFonts(installed);
    }

    private static String createLocalName(String url){
        String extension = url.substring(url.lastIndexOf("."));
        return ConfigurationHelper.getProperty(Properties.FONT_PATH) + url.replaceAll("[^a-zA-Z0-9]", "") + extension;
    }

    private static void downloadAndSaveFile(String fileUrl, String savePath){
        try {

            URL url = new URL(fileUrl);
            BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
            FileOutputStream outputStream = new FileOutputStream(savePath);

            byte[] buffer = new byte[1024];
            int count;
            while (true) {
                if (!((count = inputStream.read(buffer, 0, 1024)) != -1)) break;
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveWroteFonts(List<String> fonts){
        StringBuilder sb = new StringBuilder();
        for (String font : fonts){
            sb.append(font);
            sb.append("\n");
        }
        try (OutputStream outputStream = new FileOutputStream("fonts")) {
            byte[] data = sb.toString().getBytes();
            outputStream.write(data);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

}
