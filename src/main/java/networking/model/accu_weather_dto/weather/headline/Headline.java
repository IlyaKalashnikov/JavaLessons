package networking.model.accu_weather_dto.weather.headline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline {
    @JsonProperty(value = "EffectiveDate")
    private Date effectiveDate;
    @JsonProperty(value = "EffectiveEpochDate")
    private int effectiveEpochDate;
    @JsonProperty(value = "Severity")
    private int severity;
    @JsonProperty(value = "Text")
    private String text;
    @JsonProperty(value = "Category")
    private String category;
    @JsonProperty(value = "EndDate")
    private Date endDate;
    @JsonProperty(value = "EndEpochDate")
    private int endEpochDate;
    @JsonProperty(value = "MobileLink")
    private String mobileLink;
    @JsonProperty(value = "Link")
    private String link;

    public String getText() {
        return text;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }
}
