package networking;

import com.fasterxml.jackson.databind.ObjectMapper;
import networking.client.WeatherClient;
import networking.enums.LocationsNumber;
import networking.service.WeatherService;
import okhttp3.OkHttpClient;

public class WeatherApp {
    public static void main(String[] args) {
        WeatherService service = new WeatherService(new WeatherClient(new OkHttpClient(),new ObjectMapper()));
        service.printLocations(LocationsNumber.ONE_HUNDRED);
        service.getForecast();
    }
}
