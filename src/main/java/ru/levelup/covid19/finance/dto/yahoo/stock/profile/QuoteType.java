
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
    "exchange",
    "shortName",
    "longName",
    "exchangeTimezoneName",
    "exchangeTimezoneShortName",
    "isEsgPopulated",
    "gmtOffSetMilliseconds",
    "underlyingSymbol",
    "quoteType",
    "symbol",
    "underlyingExchangeSymbol",
    "headSymbol",
    "messageBoardId",
    "uuid",
    "market"
})
public class QuoteType {

    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("longName")
    private String longName;
    @JsonProperty("exchangeTimezoneName")
    private String exchangeTimezoneName;
    @JsonProperty("exchangeTimezoneShortName")
    private String exchangeTimezoneShortName;
    @JsonProperty("isEsgPopulated")
    private Boolean isEsgPopulated;
    @JsonProperty("gmtOffSetMilliseconds")
    private Long gmtOffSetMilliseconds;
    @JsonProperty("underlyingSymbol")
    private Object underlyingSymbol;
    @JsonProperty("quoteType")
    private String quoteType;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("underlyingExchangeSymbol")
    private Object underlyingExchangeSymbol;
    @JsonProperty("headSymbol")
    private Object headSymbol;
    @JsonProperty("messageBoardId")
    private String messageBoardId;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("market")
    private String market;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("exchange")
    public String getExchange() {
        return exchange;
    }

    @JsonProperty("exchange")
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @JsonProperty("shortName")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("shortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("longName")
    public String getLongName() {
        return longName;
    }

    @JsonProperty("longName")
    public void setLongName(String longName) {
        this.longName = longName;
    }

    @JsonProperty("exchangeTimezoneName")
    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    @JsonProperty("exchangeTimezoneName")
    public void setExchangeTimezoneName(String exchangeTimezoneName) {
        this.exchangeTimezoneName = exchangeTimezoneName;
    }

    @JsonProperty("exchangeTimezoneShortName")
    public String getExchangeTimezoneShortName() {
        return exchangeTimezoneShortName;
    }

    @JsonProperty("exchangeTimezoneShortName")
    public void setExchangeTimezoneShortName(String exchangeTimezoneShortName) {
        this.exchangeTimezoneShortName = exchangeTimezoneShortName;
    }

    @JsonProperty("isEsgPopulated")
    public Boolean getIsEsgPopulated() {
        return isEsgPopulated;
    }

    @JsonProperty("isEsgPopulated")
    public void setIsEsgPopulated(Boolean isEsgPopulated) {
        this.isEsgPopulated = isEsgPopulated;
    }

    @JsonProperty("gmtOffSetMilliseconds")
    public Long getGmtOffSetMilliseconds() {
        return gmtOffSetMilliseconds;
    }

    @JsonProperty("gmtOffSetMilliseconds")
    public void setGmtOffSetMilliseconds(Long gmtOffSetMilliseconds) {
        this.gmtOffSetMilliseconds = gmtOffSetMilliseconds;
    }

    @JsonProperty("underlyingSymbol")
    public Object getUnderlyingSymbol() {
        return underlyingSymbol;
    }

    @JsonProperty("underlyingSymbol")
    public void setUnderlyingSymbol(Object underlyingSymbol) {
        this.underlyingSymbol = underlyingSymbol;
    }

    @JsonProperty("quoteType")
    public String getQuoteType() {
        return quoteType;
    }

    @JsonProperty("quoteType")
    public void setQuoteType(String quoteType) {
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

    @JsonProperty("underlyingExchangeSymbol")
    public Object getUnderlyingExchangeSymbol() {
        return underlyingExchangeSymbol;
    }

    @JsonProperty("underlyingExchangeSymbol")
    public void setUnderlyingExchangeSymbol(Object underlyingExchangeSymbol) {
        this.underlyingExchangeSymbol = underlyingExchangeSymbol;
    }

    @JsonProperty("headSymbol")
    public Object getHeadSymbol() {
        return headSymbol;
    }

    @JsonProperty("headSymbol")
    public void setHeadSymbol(Object headSymbol) {
        this.headSymbol = headSymbol;
    }

    @JsonProperty("messageBoardId")
    public String getMessageBoardId() {
        return messageBoardId;
    }

    @JsonProperty("messageBoardId")
    public void setMessageBoardId(String messageBoardId) {
        this.messageBoardId = messageBoardId;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("market")
    public String getMarket() {
        return market;
    }

    @JsonProperty("market")
    public void setMarket(String market) {
        this.market = market;
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
