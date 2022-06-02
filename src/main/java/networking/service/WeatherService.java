package networking.service;

import networking.client.WeatherClient;
import networking.enums.LocationsNumber;
import networking.exceptions.FailedToParseDataException;
import networking.mapper.WeatherMapper;
import networking.model.accu_weather_dto.locations.LocationDto;
import networking.model.accu_weather_dto.weather.WeatherDto;
import networking.repository.FileWeatherRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WeatherService {
    private final WeatherClient weatherClient;
    private final FileWeatherRepository fileWeatherRepository;
    private final WeatherMapper weatherMapper;

    public WeatherService(WeatherClient weatherClient,
                          FileWeatherRepository fileWeatherRepository,
                          WeatherMapper weatherMapper) {
        this.weatherClient = weatherClient;
        this.fileWeatherRepository = fileWeatherRepository;
        this.weatherMapper = weatherMapper;
    }

    public Map<String, String> getLocations(LocationsNumber number) {
        List<LocationDto> locations = null;
        try {
            locations = weatherClient.getLocations(number);
        } catch (FailedToParseDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> locationKeyMap = new HashMap<>();
        for (LocationDto locationDto : locations) {
            locationKeyMap.put(locationDto.getLocalizedName(),
                    locationDto.getKey());
        }
        return locationKeyMap;
    }

    public void getForecast(LocationsNumber number) {
        Map<String, String> locationKeyMap = getLocations(number);
        System.out.println(locationKeyMap.keySet());

        System.out.println("Чтобы узнать погоду, введите название города: ");
        WeatherDto forecast = null;
        try {
            String city = chooseLocation(locationKeyMap);
            forecast = weatherClient.getForecast(locationKeyMap.get(city));

            fileWeatherRepository.saveData(weatherMapper.toWeatherEntity(city, locationKeyMap.get(city), forecast));

        } catch (FailedToParseDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        printForecast(forecast);
    }


    private void printForecast(WeatherDto forecast) {
        System.out.println(forecast.getMainForecast());
        System.out.printf("Температура от %s до %s %n", forecast.getMinTemperatureForToday(),
                forecast.getMaxTemperatureForToday());
        System.out.printf("Днем %s %n", forecast.getDayForecast().toLowerCase());
        System.out.printf("Ночью %s", forecast.getNightForecast().toLowerCase());
    }


    private String chooseLocation(Map<String, String> locationKeyMap) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String city = sc.nextLine();
            if (locationKeyMap.containsKey(city)) {
                return city;
            }

            System.out.println("Погода в этом городе недоступна. \n" +
                    "Пожалуйста, выберите другой город.");
        }
    }
}