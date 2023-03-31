package com.endtech.googlefontscraper.googlefonts.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoogleFontFilesDTO {

    private String regular;
    private String italic;
    @SerializedName("100")
    private String one;
    @SerializedName("100italic")
    private String oneItalic;
    @SerializedName("200")
    private String two;
    @SerializedName("200italic")
    private String twoItalix;
    @SerializedName("300")
    private String three;
    @SerializedName("300italic")
    private String threeItalic;
    @SerializedName("400")
    private String four;
    @SerializedName("400italic")
    private String fourItalic;
    @SerializedName("500")
    private String five;
    @SerializedName("500italic")
    private String fiveItalic;
    @SerializedName("600")
    private String six;
    @SerializedName("600italic")
    private String sixItalix;
    @SerializedName("700")
    private String seven;
    @SerializedName("700italic")
    private String sevenItalic;
    @SerializedName("800")
    private String eight;
    @SerializedName("800italic")
    private String eightItalic;
    @SerializedName("900")
    private String nine;
    @SerializedName("900italic")
    private String nineItalic;

}
