package networking_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import networking.client.WeatherClient;
import networking.enums.LocationsNumber;
import networking.exceptions.FailedToParseDataException;
import networking.model.accu_weather_dto.locations.LocationDto;
import networking.model.accu_weather_dto.weather.WeatherDto;
import networking.utils.PropertiesLoader;
import okhttp3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherClientTest {

    WeatherClient weatherClient;

    static String getJson(String path) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = classLoader.getResourceAsStream(path);

        String json = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return json;
    }

    private static OkHttpClient mockHttpClient(String path) throws IOException {
        final OkHttpClient okHttpClient = mock(OkHttpClient.class);

        final Call remoteCall = mock(Call.class);

        final Response response = new Response.Builder()
                .request(new Request.Builder().url("http://url.com").build())
                .protocol(Protocol.HTTP_1_1)
                .code(200).message("").body(
                        ResponseBody.create(
                                MediaType.parse("application/json"),
                                getJson(path)
                        ))
                .build();

        when(remoteCall.execute()).thenReturn(response);
        when(okHttpClient.newCall(any())).thenReturn(remoteCall);

        return okHttpClient;
    }

    @Test
    void getLocations_ShouldReturnLocationList() throws IOException {
        OkHttpClient mockedClient = mockHttpClient("locations_json");
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        WeatherClient weatherClient = new WeatherClient(mockedClient, new ObjectMapper(), propertiesLoader);

        List<LocationDto> list = weatherClient.getLocations(LocationsNumber.FIFTY);

        Assertions.assertTrue(list.size() == 50);
    }

    @Test
    void getForecast_ShouldReturnWeatherDtoObject() throws IOException {
        OkHttpClient mockedClient = mockHttpClient("forecast_json.json");
        PropertiesLoader mockedLoader = Mockito.mock(PropertiesLoader.class);

        WeatherClient weatherClient = new WeatherClient(mockedClient, new ObjectMapper(), mockedLoader);
        WeatherDto forecast = weatherClient.getForecast("anyKey");
        Assertions.assertTrue(forecast != null);
    }
}
