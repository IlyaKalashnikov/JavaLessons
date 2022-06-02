package networking.model.accu_weather_dto.locations.geoposition.elevation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metric {
    @JsonProperty(value = "Value")
    private int value;
    @JsonProperty(value = "Unit")
    private String unit;
    @JsonProperty(value = "UnitType")
    private int unitType;
}