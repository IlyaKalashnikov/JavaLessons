package networking.model.accu_weather_dto.locations.administrative_area;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
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
