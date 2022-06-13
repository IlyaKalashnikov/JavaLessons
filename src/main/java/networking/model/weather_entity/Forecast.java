package networking.model.weather_entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Forecast {
    private final String mainForecast;
    private final double minTemperature;
    private final double maxTemperature;
    private final Date date;

    public Forecast(String mainForecast, double minTemperature, double maxTemperature, Date date) {
        this.mainForecast = mainForecast;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.date = date;
    }

    public String getMainForecast() {
        return mainForecast;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String stringDate = df.format(date);
        return  stringDate + ";" + mainForecast + ";" + Double.toString(minTemperature) + ";" + Double.toString(maxTemperature);
    }
}
