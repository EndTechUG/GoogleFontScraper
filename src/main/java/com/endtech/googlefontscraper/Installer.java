package com.endtech.googlefontscraper;

import com.endtech.googlefontscraper.googlefonts.GoogleFontsAPI;
import com.endtech.googlefontscraper.googlefonts.dtos.GoogleFontsResponseDTO;
import com.endtech.googlefontscraper.processor.FontProcessor;

public class Installer {
    public static void main(String[] args) {

        GoogleFontsResponseDTO response = GoogleFontsAPI.getFonts();
        if (response == null) return;
        FontProcessor.process(response);

    }
}
