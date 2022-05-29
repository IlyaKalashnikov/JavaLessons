package networking.data_models.weather.temperature;

import com.fasterxml.jackson.annotation.JsonProperty;

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
