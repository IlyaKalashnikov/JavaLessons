package networking.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import networking.model.accu_weather_dto.locations.LocationDto;
import networking.model.accu_weather_dto.weather.WeatherDto;
import networking.enums.LocationsNumber;
import networking.exceptions.FailedToParseDataException;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class WeatherClient {
    private static final Properties properties = new Properties();

    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    public WeatherClient(OkHttpClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    private static Response response;

    private static void getProperties () throws IOException {
        try (FileReader fileReader = new FileReader("src/main/resources/application_properties.yaml")) {
            properties.load(fileReader);
       }
    }

    public List<LocationDto> getLocations(LocationsNumber number) throws FailedToParseDataException, IOException {
        getProperties();
        List<LocationDto> locations = null;

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("locations/v1/topcities")
                .addPathSegment(number.getNumber())
                .addQueryParameter("apikey",properties.getProperty("apikey"))
                .addQueryParameter("language","ru-ru")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        try {
            response = client.newCall(request).execute();
            locations = objectMapper.readValue(response.body().string(),
                    new TypeReference<List<LocationDto>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (locations == null){
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
                .addQueryParameter("apikey", properties.getProperty("apikey"))
                .addQueryParameter("language", "ru-ru")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();
        WeatherDto forecast = null;

        try {
            response = client.newCall(request).execute();
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
