package networking.mapper;

import networking.model.accu_weather_dto.weather.WeatherDto;
import networking.model.weather_entity.Forecast;
import networking.model.weather_entity.Location;
import networking.model.weather_entity.WeatherEntity;

public class WeatherMapper {

    public static WeatherEntity toWeatherEntity (String city, String key, WeatherDto weatherDto) {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setLocation(new Location(city,key));
        weatherEntity.setForecast(new Forecast(weatherDto.getMainForecast(), weatherDto.getMinTemperatureForToday(),
                weatherDto.getMaxTemperatureForToday(), weatherDto.getDate()));
        return  weatherEntity;
    }
}
