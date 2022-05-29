package networking.data_models.weather.day;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Day {
    @JsonProperty(value = "Icon")
    private int icon;
    @JsonProperty(value = "IconPhrase")
    private String iconPhrase;
    @JsonProperty(value = "HasPrecipitation")
    private boolean hasPrecipitation;
    @JsonProperty(value = "PrecipitationType")
    private String precipitationType;
    @JsonProperty(value = "PrecipitationIntensity")
    private String precipitationIntensity;

    public String getIconPhrase() {
        return iconPhrase;
    }
}
