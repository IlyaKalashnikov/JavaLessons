package networking_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import networking.client.WeatherClient;
import networking.enums.LocationsNumber;
import networking.mapper.WeatherMapper;
import networking.model.accu_weather_dto.locations.LocationDto;
import networking.model.accu_weather_dto.weather.WeatherDto;
import networking.repository.DbWeatherRepository;
import networking.repository.FileWeatherRepository;
import networking.service.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {
    WeatherClient mockedClient = Mockito.mock(WeatherClient.class);
    FileWeatherRepository mockedRepo = Mockito.mock(FileWeatherRepository.class);
    WeatherMapper mockedMapper = Mockito.mock(WeatherMapper.class);

    DbWeatherRepository mockedDbRepo = Mockito.mock(DbWeatherRepository.class);
    WeatherService weatherService = new WeatherService(mockedClient, mockedRepo, mockedMapper, mockedDbRepo);

    @Test
    void getLocations_ShouldReturnLocationsMap() throws IOException {
        LocationDto locationDto = Mockito.mock(LocationDto.class);
        List<LocationDto> locationDtoList = new ArrayList<>();
        locationDtoList.add(locationDto);
        when(mockedClient.getLocations(any())).thenReturn(locationDtoList);
        when(locationDto.getLocalizedName()).thenReturn("Москва");
        when(locationDto.getKey()).thenReturn("111");

        Map<String, String> locationsMap = weatherService.getLocations(LocationsNumber.FIFTY);
        Assertions.assertTrue(locationsMap.containsKey("Москва") && locationsMap.containsValue("111"));
    }

    @Test
    void getForecast_ShouldReturnForecast() throws JsonProcessingException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = classLoader.getResourceAsStream("forecast_json.json");

        Map<String, String> locations = new HashMap<>();
        locations.put("Москва", "111");

        when(weatherService.getLocations(any())).thenReturn(locations);
        when(weatherService.chooseLocation(any())).thenReturn("111");
        when(mockedClient.getForecast(any())).thenReturn(new ObjectMapper().readValue(new BufferedReader(
                new InputStreamReader(in, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n")), WeatherDto.class
        ));
        WeatherDto forecast = weatherService.getForecast(LocationsNumber.FIFTY);

        Assertions.assertTrue(forecast != null);

    }


}
