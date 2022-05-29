package networking.data_models.weather.headline;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

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
}
