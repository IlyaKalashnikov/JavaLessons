package networking;

import com.fasterxml.jackson.databind.ObjectMapper;
import networking.client.WeatherClient;
import networking.enums.LocationsNumber;
import networking.mapper.WeatherMapper;
import networking.repository.DbWeatherRepository;
import networking.repository.FileWeatherRepository;
import networking.service.WeatherService;
import networking.utils.PropertiesLoader;
import okhttp3.OkHttpClient;

public class WeatherApp {
    public static void main(String[] args) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        FileWeatherRepository fileWeatherRepository = new FileWeatherRepository();
        DbWeatherRepository dbWeatherRepository = new DbWeatherRepository();

        WeatherMapper weatherMapper = new WeatherMapper();
        WeatherService service = new WeatherService(
                new WeatherClient(
                        new OkHttpClient(),
                        new ObjectMapper(),
                        propertiesLoader),
                fileWeatherRepository,
                weatherMapper,
                dbWeatherRepository);
        service.printForecast(LocationsNumber.ONE_HUNDRED);
    }
}
