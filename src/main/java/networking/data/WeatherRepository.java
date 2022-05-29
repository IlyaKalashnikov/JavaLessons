package networking.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import networking.data_models.locations.Location;
import networking.data_models.weather.Weather;
import networking.exceptions.FailedToParseDataException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WeatherRepository {
    private static final String BASE_URL = "http://dataservice.accuweather.com/";
    private static final String PATH_FOR_LOCATIONS = "locations/v1/topcities/50";
    private static final String PATH_FOR_FORECAST = "forecasts/v1/daily/1day/";
    private static final String API_KEY = "?apikey=Rqjnc9A0ukl3om0tUvnIILQoXKrT65Xu";
    private static final String LANGUAGE = "&language=ru-ru";
    private static final String METRIC = "&metric=true";

    private static final OkHttpClient client = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static Request request;
    private static Response response;


    public static List<Location> getLocations() throws FailedToParseDataException {
        List<Location> locations = null;
        request = new Request.Builder()
                .url(BASE_URL + PATH_FOR_LOCATIONS + API_KEY + LANGUAGE)
                .build();

        try {
            response = client.newCall(request).execute();
            locations = objectMapper.readValue(response.body().string(),
                    new TypeReference<List<Location>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (locations == null){
            throw new FailedToParseDataException("Возникла ошибка при распаковке данных.");
        }
        return Collections.unmodifiableList(locations);
    }

    public static Weather getForecast(String locationKey) throws FailedToParseDataException {
        request = new Request.Builder()
                .url(BASE_URL+PATH_FOR_FORECAST+locationKey+API_KEY+LANGUAGE+METRIC)
                .build();
        Weather forecast = null;

        try {
            response = client.newCall(request).execute();
            forecast = objectMapper.readValue(response.body().string(), Weather.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (forecast == null) {
            throw new FailedToParseDataException("Возникла ошибка при распаковке факлов.");
        }
        return forecast;
    }
}
