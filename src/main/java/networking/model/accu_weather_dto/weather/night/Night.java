package networking.model.accu_weather_dto.weather.night;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Night {
    @JsonProperty(value = "Icon")
    private int icon;
    @JsonProperty(value = "IconPhrase")
    private String iconPhrase;
    @JsonProperty(value = "HasPrecipitation")
    private boolean hasPrecipitation;

    public String getIconPhrase() {
        return iconPhrase;
    }
}
