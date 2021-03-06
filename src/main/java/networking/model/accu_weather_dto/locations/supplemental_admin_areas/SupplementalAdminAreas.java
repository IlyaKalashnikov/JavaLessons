package networking.model.accu_weather_dto.locations.supplemental_admin_areas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplementalAdminAreas {
    @JsonProperty(value = "Level")
    private int level;
    @JsonProperty(value = "LocalizedName")
    private String localizedName;
    @JsonProperty(value = "EnglishName")
    private String englishName;
}
