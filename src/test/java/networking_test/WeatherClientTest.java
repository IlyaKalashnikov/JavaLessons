package networking_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import networking.client.WeatherClient;
import networking.enums.LocationsNumber;
import networking.exceptions.FailedToParseDataException;
import networking.model.accu_weather_dto.locations.LocationDto;
import networking.utils.PropertiesLoader;
import okhttp3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherClientTest {

    WeatherClient weatherClient;

    static String getLocationsJson() {
        ArrayList<String> locationsJson = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/locations_json"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                locationsJson.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return locationsJson.toString();
    }

    private static OkHttpClient mockHttpClient(String serializedResponse) throws IOException {
        final OkHttpClient okHttpClient = mock(OkHttpClient.class);

        final Call remoteCall = mock(Call.class);

        final Response response = new Response.Builder()
                .request(new Request.Builder().url("http://url.com").build())
                .protocol(Protocol.HTTP_1_1)
                .code(200).message("").body(
                        ResponseBody.create(
                                MediaType.parse("application/json"),
                                serializedResponse
                        ))
                .build();

        when(remoteCall.execute()).thenReturn(response);
        when(okHttpClient.newCall(any())).thenReturn(remoteCall);

        return okHttpClient;
    }

    @Test
    void getLocations_ShouldReturnLocationList() throws IOException, FailedToParseDataException {
        OkHttpClient mockedClient = mockHttpClient(getLocationsJson());
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        WeatherClient weatherClient = new WeatherClient(mockedClient, new ObjectMapper(), propertiesLoader);

        List<LocationDto> list = weatherClient.getLocations(LocationsNumber.ONE_HUNDRED);

        Assertions.assertTrue(list.size() == 50);
    }
}
