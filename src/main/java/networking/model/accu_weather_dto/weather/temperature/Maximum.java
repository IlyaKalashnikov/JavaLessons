package networking.model.accu_weather_dto.weather.temperature;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Maximum {
    @JsonProperty(value = "Value")
    private double value;
    @JsonProperty(value = "Unit")
    private String unit;
    @JsonProperty(value = "UnitType")
    private int unitType;

    public double getValue() {
        return value;
    }
}
