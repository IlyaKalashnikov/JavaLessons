package networking.data_models.locations.administrative_area;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdministrativeArea {
    @JsonProperty(value = "ID")
    private String id;
    @JsonProperty(value = "LocalizedName")
    private String localizedName;
    @JsonProperty(value = "EnglishName")
    private String englishName;
    @JsonProperty(value = "Level")
    private int level;
    @JsonProperty(value = "LocalizedType")
    private String localizedType;
    @JsonProperty(value = "EnglishType")
    private String englishType;
    @JsonProperty(value = "CountryID")
    private String countryId;
}
