package networking.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import networking.enums.LocationsNumber;
import networking.exceptions.FailedToParseDataException;
import networking.model.accu_weather_dto.locations.LocationDto;
import networking.model.accu_weather_dto.weather.WeatherDto;
import networking.utils.PropertiesLoader;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WeatherClient {
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;
    private final PropertiesLoader propertiesLoader;

    public WeatherClient(OkHttpClient client,
                         ObjectMapper objectMapper,
                         PropertiesLoader propertiesLoader) {
        this.client = client;
        this.objectMapper = objectMapper;
        this.propertiesLoader = propertiesLoader;
    }

    public List<LocationDto> getLocations(LocationsNumber number) throws FailedToParseDataException, IOException {
        List<LocationDto> locations = null;

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("locations/v1/topcities")
                .addPathSegment(number.getNumber())
                .addQueryParameter("apikey", propertiesLoader.getProperty("apikey"))
                .addQueryParameter("language", "ru-ru")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        try {
            Response response = client.newCall(request).execute();
            locations = objectMapper.readValue(response.body().string(),
                    new TypeReference<List<LocationDto>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (locations == null) {
            throw new FailedToParseDataException("Возникла ошибка при распаковке данных.");
        }
        return Collections.unmodifiableList(locations);
    }

    public WeatherDto getForecast(String locationKey) throws FailedToParseDataException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("forecasts/v1/daily/1day/")
                .addPathSegment(locationKey)
                .addQueryParameter("apikey", propertiesLoader.getProperty("apikey"))
                .addQueryParameter("language", "ru-ru")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();
        WeatherDto forecast = null;

        try {
            Response response = client.newCall(request).execute();
            forecast = objectMapper.readValue(response.body().string(), WeatherDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (forecast == null) {
            throw new FailedToParseDataException("Возникла ошибка при распаковке факлов.");
        }
        return forecast;
    }
}
