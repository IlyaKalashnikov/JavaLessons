package networking.repository;

import networking.model.weather_entity.WeatherEntity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWeatherRepository {
    private final File weatherRepository = new File("src/main/resources/forecast.csv");

    public void saveData(WeatherEntity entity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(weatherRepository, true))) {
            String line = entity.toString();
            writer.write(line);
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Successfully uploaded forecast to file");
    }
}
