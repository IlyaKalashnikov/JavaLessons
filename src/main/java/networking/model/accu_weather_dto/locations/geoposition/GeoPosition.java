package networking.model.accu_weather_dto.locations.geoposition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import networking.model.accu_weather_dto.locations.geoposition.elevation.Elevation;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPosition {
    @JsonProperty(value = "Latitude")
    private double latitude;
    @JsonProperty(value = "Longitude")
    private double longitude;
    @JsonProperty(value = "Elevation")
    private Elevation elevation;
}
