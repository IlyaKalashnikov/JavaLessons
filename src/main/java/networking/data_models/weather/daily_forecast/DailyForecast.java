package networking.data_models.weather.daily_forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import networking.data_models.weather.day.Day;
import networking.data_models.weather.night.Night;
import networking.data_models.weather.temperature.Temperature;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {
    @JsonProperty(value = "Date")
    private Date date;
    @JsonProperty(value = "EpochDate")
    private int epochDate;
    @JsonProperty(value = "Temperature")
    private Temperature temperature;
    @JsonProperty(value = "Day")
    private Day day;
    @JsonProperty(value = "Night")
    private Night night;
    @JsonProperty(value = "Sources")
    private ArrayList<String> sources;
    @JsonProperty(value = "MobileLink")
    private String mobileLink;
    @JsonProperty(value = "Link")
    private String link;

    public Temperature getTemperature() {
        return temperature;
    }

    public Day getDay() {
        return day;
    }

    public Night getNight() {
        return night;
    }
}

