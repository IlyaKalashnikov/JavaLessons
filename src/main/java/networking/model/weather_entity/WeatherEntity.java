package networking.model.weather_entity;

import java.util.Date;

public class WeatherEntity {
    private Location location;
    private Forecast forecast;

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public String getLocationName() {
        return location.getName();
    }

    public String getLocationId() {
        return location.getKey();
    }

    public String getDate() {
        return forecast.getDate().toString();
    }

    public String getMainForecast() {
        return forecast.getMainForecast();
    }

    public Double getMinTemp() {
        return forecast.getMinTemperature();
    }

    public Double getMaxTemp() {
        return forecast.getMaxTemperature();
    }

    @Override
    public String toString() {
        return location.toString() + forecast.toString();
    }
}
