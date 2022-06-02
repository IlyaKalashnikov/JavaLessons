package networking.model.accu_weather_dto.weather.daily_forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import networking.model.accu_weather_dto.weather.day.Day;
import networking.model.accu_weather_dto.weather.night.Night;
import networking.model.accu_weather_dto.weather.temperature.Temperature;

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

