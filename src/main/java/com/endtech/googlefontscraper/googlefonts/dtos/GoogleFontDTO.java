package com.endtech.googlefontscraper.googlefonts.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoogleFontDTO {
    private String category;
    private String family;
    private GoogleFontFilesDTO files;
    private String kind;
}
