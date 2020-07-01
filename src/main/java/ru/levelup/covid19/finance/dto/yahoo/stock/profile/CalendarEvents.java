
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
    "maxAge",
    "earnings",
    "exDividendDate",
    "dividendDate"
})
public class CalendarEvents {

    @JsonProperty("maxAge")
    private Integer maxAge;
    @JsonProperty("earnings")
    private Earnings earnings;
    @JsonProperty("exDividendDate")
    private ExDividendDate_ exDividendDate;
    @JsonProperty("dividendDate")
    private DividendDate dividendDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("maxAge")
    public Integer getMaxAge() {
        return maxAge;
    }

    @JsonProperty("maxAge")
    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @JsonProperty("earnings")
    public Earnings getEarnings() {
        return earnings;
    }

    @JsonProperty("earnings")
    public void setEarnings(Earnings earnings) {
        this.earnings = earnings;
    }

    @JsonProperty("exDividendDate")
    public ExDividendDate_ getExDividendDate() {
        return exDividendDate;
    }

    @JsonProperty("exDividendDate")
    public void setExDividendDate(ExDividendDate_ exDividendDate) {
        this.exDividendDate = exDividendDate;
    }

    @JsonProperty("dividendDate")
    public DividendDate getDividendDate() {
        return dividendDate;
    }

    @JsonProperty("dividendDate")
    public void setDividendDate(DividendDate dividendDate) {
        this.dividendDate = dividendDate;
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
