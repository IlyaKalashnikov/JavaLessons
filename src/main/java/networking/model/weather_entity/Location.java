package networking.model.weather_entity;


public class Location {
    private final String name;
    private final String key;

    public Location(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return name + ";" + key + ";";
    }
}
