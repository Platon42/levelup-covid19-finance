
package ru.levelup.covid19.finance.dto.yahoo.stock.historical;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "prices",
        "isPending",
        "firstTradeDate",
        "id",
        "timeZone",
        "eventsData"
})
public class HistoricalDataProvider {

    @JsonProperty("prices")
    private List<Price> prices = null;
    @JsonProperty("isPending")
    private Boolean isPending;
    @JsonProperty("firstTradeDate")
    private Integer firstTradeDate;
    @JsonProperty("id")
    private String id;
    @JsonProperty("timeZone")
    private TimeZone timeZone;
    @JsonProperty("eventsData")
    private List<Object> eventsData = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("prices")
    public List<Price> getPrices() {
        return prices;
    }

    @JsonProperty("prices")
    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @JsonProperty("isPending")
    public Boolean getIsPending() {
        return isPending;
    }

    @JsonProperty("isPending")
    public void setIsPending(Boolean isPending) {
        this.isPending = isPending;
    }

    @JsonProperty("firstTradeDate")
    public Integer getFirstTradeDate() {
        return firstTradeDate;
    }

    @JsonProperty("firstTradeDate")
    public void setFirstTradeDate(Integer firstTradeDate) {
        this.firstTradeDate = firstTradeDate;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("timeZone")
    public TimeZone getTimeZone() {
        return timeZone;
    }

    @JsonProperty("timeZone")
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("eventsData")
    public List<Object> getEventsData() {
        return eventsData;
    }

    @JsonProperty("eventsData")
    public void setEventsData(List<Object> eventsData) {
        this.eventsData = eventsData;
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
