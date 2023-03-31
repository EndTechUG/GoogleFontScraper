package com.endtech.googlefontscraper.googlefonts.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoogleFontsResponseDTO {
    private List<GoogleFontDTO> items;
}
