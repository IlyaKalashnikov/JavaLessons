package networking.model.accu_weather_dto.locations.geoposition.elevation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Elevation {
    @JsonProperty(value = "Metric")
    private Metric metric;
    @JsonProperty(value = "Imperial")
    private Imperial imperial;
}
