package networking.data_models.locations.geoposition;

import com.fasterxml.jackson.annotation.JsonProperty;
import networking.data_models.locations.geoposition.elevation.Elevation;

public class GeoPosition {
    @JsonProperty(value = "Latitude")
    private double latitude;
    @JsonProperty(value = "Longitude")
    private double longitude;
    @JsonProperty(value = "Elevation")
    private Elevation elevation;
}
