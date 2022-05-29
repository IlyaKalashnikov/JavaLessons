package networking;

import networking.data.WeatherRepository;
import networking.service.WeatherService;

public class WeatherApp {
    public static void main(String[] args) {
        WeatherService service = new WeatherService(new WeatherRepository());
        service.printLocations();
        service.printWeather();
    }
}
