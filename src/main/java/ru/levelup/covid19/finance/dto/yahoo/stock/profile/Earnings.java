package ru.levelup.covid19.finance.dto.yahoo.stock.profile;

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
    "earningsDate",
    "earningsAverage",
    "earningsLow",
    "earningsHigh",
    "revenueAverage",
    "revenueLow",
    "revenueHigh"
})
public class Earnings {

    @JsonProperty("earningsDate")
    private List<EarningsDate> earningsDate = null;
    @JsonProperty("earningsAverage")
    private EarningsAverage earningsAverage;
    @JsonProperty("earningsLow")
    private EarningsLow earningsLow;
    @JsonProperty("earningsHigh")
    private EarningsHigh earningsHigh;
    @JsonProperty("revenueAverage")
    private RevenueAverage revenueAverage;
    @JsonProperty("revenueLow")
    private RevenueLow revenueLow;
    @JsonProperty("revenueHigh")
    private RevenueHigh revenueHigh;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("earningsDate")
    public List<EarningsDate> getEarningsDate() {
        return earningsDate;
    }

    @JsonProperty("earningsDate")
    public void setEarningsDate(List<EarningsDate> earningsDate) {
        this.earningsDate = earningsDate;
    }

    @JsonProperty("earningsAverage")
    public EarningsAverage getEarningsAverage() {
        return earningsAverage;
    }

    @JsonProperty("earningsAverage")
    public void setEarningsAverage(EarningsAverage earningsAverage) {
        this.earningsAverage = earningsAverage;
    }

    @JsonProperty("earningsLow")
    public EarningsLow getEarningsLow() {
        return earningsLow;
    }

    @JsonProperty("earningsLow")
    public void setEarningsLow(EarningsLow earningsLow) {
        this.earningsLow = earningsLow;
    }

    @JsonProperty("earningsHigh")
    public EarningsHigh getEarningsHigh() {
        return earningsHigh;
    }

    @JsonProperty("earningsHigh")
    public void setEarningsHigh(EarningsHigh earningsHigh) {
        this.earningsHigh = earningsHigh;
    }

    @JsonProperty("revenueAverage")
    public RevenueAverage getRevenueAverage() {
        return revenueAverage;
    }

    @JsonProperty("revenueAverage")
    public void setRevenueAverage(RevenueAverage revenueAverage) {
        this.revenueAverage = revenueAverage;
    }

    @JsonProperty("revenueLow")
    public RevenueLow getRevenueLow() {
        return revenueLow;
    }

    @JsonProperty("revenueLow")
    public void setRevenueLow(RevenueLow revenueLow) {
        this.revenueLow = revenueLow;
    }

    @JsonProperty("revenueHigh")
    public RevenueHigh getRevenueHigh() {
        return revenueHigh;
    }

    @JsonProperty("revenueHigh")
    public void setRevenueHigh(RevenueHigh revenueHigh) {
        this.revenueHigh = revenueHigh;
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
