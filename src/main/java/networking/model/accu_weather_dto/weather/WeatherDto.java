package networking.model.accu_weather_dto.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import networking.model.accu_weather_dto.weather.daily_forecast.DailyForecast;
import networking.model.accu_weather_dto.weather.headline.Headline;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {
    @JsonProperty(value = "Headline")
    private Headline headline;
    @JsonProperty(value = "DailyForecasts")
    private ArrayList<DailyForecast> dailyForecasts;

    public String getMainForecast() {
        return headline.getText();
    }

    public double getMinTemperatureForToday() {
        return dailyForecasts.get(0).getTemperature().getMinimum().getValue();
    }

    public double getMaxTemperatureForToday() {
        return dailyForecasts.get(0).getTemperature().getMaximum().getValue();
    }

    public String getDayForecast() {
        return dailyForecasts.get(0).getDay().getIconPhrase();
    }

    public String getNightForecast() {
        return dailyForecasts.get(0).getNight().getIconPhrase();
    }

    public Date getDate() {
        return headline.getEffectiveDate();
    }
}
