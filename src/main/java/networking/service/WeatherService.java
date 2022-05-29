package networking.service;

import networking.data.WeatherRepository;
import networking.data_models.locations.Location;
import networking.data_models.weather.Weather;
import networking.exceptions.FailedToParseDataException;
import networking.exceptions.NoSuchLocationException;

import java.util.*;

public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final Map<String, String> locationKeyMap = new HashMap<>();

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public void getLocations() {
        List<Location> locations = null;
        try {
            locations = weatherRepository.getLocations();
        } catch (FailedToParseDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        saveLocations(locations);
    }

    private void saveLocations(List<Location> locations) {
        for (Location location : locations) {
            locationKeyMap.put(location.getLocalizedName(),
                    location.getKey());
        }
    }

    public void printLocations() {
        getLocations();
        System.out.println(locationKeyMap.keySet());
    }

    public void printWeather() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Чтобы узнать погоду, введите название города: ");
        Weather forecast = null;
        try {
            String city = chooseLocation();
            forecast = weatherRepository.getForecast(locationKeyMap.get(city));
        } catch (FailedToParseDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(forecast.getMainForecast());
        System.out.printf("Температура от %s до %s %n", forecast.getMinTemperatureForToday(),
                forecast.getMaxTemperatureForToday());
        System.out.printf("Днем %s %n", forecast.getDayForecast().toLowerCase());
        System.out.printf("Ночью %s", forecast.getNightForecast().toLowerCase());
    }

    private String chooseLocation() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String city = sc.nextLine();
                if (!locationKeyMap.keySet().contains(city)) {
                    throw new NoSuchLocationException("Погода в этом городе недоступна. \n" +
                            "Пожалуйста, выберите другой город.");
                } else return city;
            } catch (NoSuchLocationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}