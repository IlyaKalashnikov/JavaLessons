package networking.model.accu_weather_dto.locations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import networking.model.accu_weather_dto.locations.administrative_area.AdministrativeArea;
import networking.model.accu_weather_dto.locations.country.Country;
import networking.model.accu_weather_dto.locations.geoposition.GeoPosition;
import networking.model.accu_weather_dto.locations.region.Region;
import networking.model.accu_weather_dto.locations.supplemental_admin_areas.SupplementalAdminAreas;
import networking.model.accu_weather_dto.locations.timezone.TimeZone;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto {
    @JsonProperty(value = "Version")
    private int version;
    @JsonProperty(value = "Key")
    private String key;
    @JsonProperty(value = "Type")
    private String type;
    @JsonProperty(value = "Rank")
    private int rank;
    @JsonProperty(value = "LocalizedName")
    private String localizedName;
    @JsonProperty(value = "EnglishName")
    private String englishName;
    @JsonProperty(value = "PrimaryPostalCode")
    private String primaryPostalCode;
    @JsonProperty(value = "Region")
    private Region region;
    @JsonProperty(value = "Country")
    private Country country;
    @JsonProperty(value = "AdministrativeArea")
    private AdministrativeArea administrativeArea;
    @JsonProperty(value = "TimeZone")
    private TimeZone timeZone;
    @JsonProperty(value = "GeoPosition")
    private GeoPosition geoPosition;
    @JsonProperty(value = "IsAlias")
    private boolean isAlias;
    @JsonProperty(value = "SupplementalAdminAreas")
    private ArrayList<SupplementalAdminAreas> supplementalAdminAreas;
    @JsonProperty(value = "DataSets")
    private ArrayList<String> dataSets;

    public String getKey() {
        return key;
    }

    public String getLocalizedName() {
        return localizedName;
    }

}

