package networking.data_models.locations.supplemental_admin_areas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SupplementalAdminAreas {
    @JsonProperty(value = "Level")
    private int level;
    @JsonProperty(value = "LocalizedName")
    private String localizedName;
    @JsonProperty(value = "EnglishName")
    private String englishName;
}