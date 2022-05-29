package networking.data_models.locations.country;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
    @JsonProperty(value = "ID")
    String id;
    @JsonProperty(value = "LocalizedName")
    String localizedName;
    @JsonProperty(value = "EnglishName")
    String englishName;
}
