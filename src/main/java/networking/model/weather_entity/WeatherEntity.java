package networking.model.weather_entity;

public class WeatherEntity {
    private Location location;
    private Forecast forecast;

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return location.toString() + forecast.toString();
    }
}
