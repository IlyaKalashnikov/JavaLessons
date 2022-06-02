package networking.model.accu_weather_dto.weather.temperature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    @JsonProperty(value = "Minimum")
    private Minimum minimum;
    @JsonProperty(value = "Maximum")
    private Maximum maximum;

    public Minimum getMinimum() {
        return minimum;
    }

    public Maximum getMaximum() {
        return maximum;
    }
}
