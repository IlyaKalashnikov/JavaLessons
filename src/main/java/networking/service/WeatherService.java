package networking.service;

import networking.client.WeatherClient;
import networking.mapper.WeatherMapper;
import networking.model.accu_weather_dto.locations.LocationDto;
import networking.model.accu_weather_dto.weather.WeatherDto;
import networking.enums.LocationsNumber;
import networking.exceptions.FailedToParseDataException;
import networking.exceptions.NoSuchLocationException;
import networking.model.weather_entity.WeatherEntity;

import java.io.*;
import java.util.*;

public class WeatherService {
    private final WeatherClient weatherClient;
    private final Map<String, String> locationKeyMap = new HashMap<>();
    private final File weatherRepository = new File("src/main/resources/forecast.csv");

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public void getLocations(LocationsNumber number) {
        List<LocationDto> locations = null;
        try {
            locations = weatherClient.getLocations(number);
        } catch (FailedToParseDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveLocations(locations);
    }

    private void saveLocations(List<LocationDto> locations) {
        for (LocationDto locationDto : locations) {
            locationKeyMap.put(locationDto.getLocalizedName(),
                    locationDto.getKey());
        }
    }

    public void printLocations(LocationsNumber number) {
        getLocations(number);
        System.out.println(locationKeyMap.keySet());
    }

    public void getForecast() {
        System.out.println("Чтобы узнать погоду, введите название города: ");
        WeatherDto forecast = null;
        try {
            String city = chooseLocation();
            forecast = weatherClient.getForecast(locationKeyMap.get(city));

            saveData(WeatherMapper.toWeatherEntity(city, locationKeyMap.get(city), forecast));

        } catch (FailedToParseDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        printForecast(forecast);
    }

    private void saveData(WeatherEntity entity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(weatherRepository))) {
            String line = entity.toString();
            writer.write(line);
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void printForecast (WeatherDto forecast) {
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
                if (!locationKeyMap.containsKey(city)) {
                    throw new NoSuchLocationException("Погода в этом городе недоступна. \n" +
                            "Пожалуйста, выберите другой город.");
                } else return city;
            } catch (NoSuchLocationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}