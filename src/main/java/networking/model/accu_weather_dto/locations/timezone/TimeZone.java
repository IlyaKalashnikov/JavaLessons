package networking.model.accu_weather_dto.locations.timezone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeZone {
    @JsonProperty(value = "Code")
    private String code;
    @JsonProperty(value = "Name")
    private String name;
    @JsonProperty(value = "GmtOffset")
    private int gmtOffset;
    @JsonProperty(value = "IsDaylightSaving")
    private boolean isDaylightSaving;
    @JsonProperty(value = "NextOffsetChange")
    private Date nextOffsetChange;
}
