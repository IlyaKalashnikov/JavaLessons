package networking.model.accu_weather_dto.locations.region;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Region {
    @JsonProperty(value = "ID")
    private String id;
    @JsonProperty(value = "LocalizedName")
    private String localizedName;
    @JsonProperty(value = "EnglishName")
    private String englishName;
}

