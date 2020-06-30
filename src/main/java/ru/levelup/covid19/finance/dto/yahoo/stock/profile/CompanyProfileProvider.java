
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
    "quoteType",
    "symbol",
    "price",
    "summaryDetail",
    "pageViews",
    "assetProfile",
    "secFilings",
    "calendarEvents"
})
public class CompanyProfileProvider {

    @JsonProperty("quoteType")
    private QuoteType quoteType;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("summaryDetail")
    private SummaryDetail summaryDetail;
    @JsonProperty("pageViews")
    private PageViews pageViews;
    @JsonProperty("assetProfile")
    private AssetProfile assetProfile;
    @JsonProperty("secFilings")
    private SecFilings secFilings;
    @JsonProperty("calendarEvents")
    private CalendarEvents calendarEvents;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonProperty("error")
    private String error = "";

    @JsonProperty("quoteType")
    public QuoteType getQuoteType() {
        return quoteType;
    }

    @JsonProperty("quoteType")
    public void setQuoteType(QuoteType quoteType) {
        this.quoteType = quoteType;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("summaryDetail")
    public SummaryDetail getSummaryDetail() {
        return summaryDetail;
    }

    @JsonProperty("summaryDetail")
    public void setSummaryDetail(SummaryDetail summaryDetail) {
        this.summaryDetail = summaryDetail;
    }

    @JsonProperty("pageViews")
    public PageViews getPageViews() {
        return pageViews;
    }

    @JsonProperty("pageViews")
    public void setPageViews(PageViews pageViews) {
        this.pageViews = pageViews;
    }

    @JsonProperty("assetProfile")
    public AssetProfile getAssetProfile() {
        return assetProfile;
    }

    @JsonProperty("assetProfile")
    public void setAssetProfile(AssetProfile assetProfile) {
        this.assetProfile = assetProfile;
    }

    @JsonProperty("secFilings")
    public SecFilings getSecFilings() {
        return secFilings;
    }

    @JsonProperty("secFilings")
    public void setSecFilings(SecFilings secFilings) {
        this.secFilings = secFilings;
    }

    @JsonProperty("calendarEvents")
    public CalendarEvents getCalendarEvents() {
        return calendarEvents;
    }

    @JsonProperty("calendarEvents")
    public void setCalendarEvents(CalendarEvents calendarEvents) {
        this.calendarEvents = calendarEvents;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("error")
    public String getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(String error) {
        this.error = error;
    }
}
