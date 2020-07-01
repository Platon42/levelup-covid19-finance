
package ru.levelup.covid19.finance.dto.yahoo.stock.profile;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "shortTermTrend",
    "midTermTrend",
    "longTermTrend",
    "maxAge"
})
public class PageViews {

    @JsonProperty("shortTermTrend")
    private String shortTermTrend;
    @JsonProperty("midTermTrend")
    private String midTermTrend;
    @JsonProperty("longTermTrend")
    private String longTermTrend;
    @JsonProperty("maxAge")
    private Integer maxAge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("shortTermTrend")
    public String getShortTermTrend() {
        return shortTermTrend;
    }

    @JsonProperty("shortTermTrend")
    public void setShortTermTrend(String shortTermTrend) {
        this.shortTermTrend = shortTermTrend;
    }

    @JsonProperty("midTermTrend")
    public String getMidTermTrend() {
        return midTermTrend;
    }

    @JsonProperty("midTermTrend")
    public void setMidTermTrend(String midTermTrend) {
        this.midTermTrend = midTermTrend;
    }

    @JsonProperty("longTermTrend")
    public String getLongTermTrend() {
        return longTermTrend;
    }

    @JsonProperty("longTermTrend")
    public void setLongTermTrend(String longTermTrend) {
        this.longTermTrend = longTermTrend;
    }

    @JsonProperty("maxAge")
    public Integer getMaxAge() {
        return maxAge;
    }

    @JsonProperty("maxAge")
    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
