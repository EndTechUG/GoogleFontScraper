package com.endtech.googlefontscraper.googlefonts;

import com.endtech.googlefontscraper.configuration.ConfigurationHelper;
import com.endtech.googlefontscraper.configuration.Properties;
import com.endtech.googlefontscraper.googlefonts.dtos.GoogleFontsResponseDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class GoogleFontsAPI {
    private static final Logger log = Logger.getLogger(GoogleFontsAPI.class.getName());
    public static GoogleFontsResponseDTO getFonts(){
        try {

            String key = ConfigurationHelper.getProperty(Properties.KEY);
            URL url = new URL(String.format("https://www.googleapis.com/webfonts/v1/webfonts?key=%s", key));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            log.info(String.valueOf(responseCode));

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();

            return new Gson().fromJson(sb.toString(), GoogleFontsResponseDTO.class);

        } catch (Exception e) {
            log.severe(e.getMessage());
        }

        return null;
    }
}
