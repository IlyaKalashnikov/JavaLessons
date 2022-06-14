package networking.model.accu_weather_dto.locations.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    @JsonProperty(value = "ID")
    String id;
    @JsonProperty(value = "LocalizedName")
    String localizedName;
    @JsonProperty(value = "EnglishName")
    String englishName;
}
