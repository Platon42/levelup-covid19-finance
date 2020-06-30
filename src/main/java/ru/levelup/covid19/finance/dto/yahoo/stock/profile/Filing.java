
package ru.levelup.covid19.finance.dto.yahoo.stock.profile;

import java.net.URI;
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
    "date",
    "epochDate",
    "type",
    "title",
    "url",
    "edgarUrl",
    "maxAge"
})
public class Filing {

    @JsonProperty("date")
    private String date;
    @JsonProperty("epochDate")
    private Integer epochDate;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private URI url;
    @JsonProperty("edgarUrl")
    private URI edgarUrl;
    @JsonProperty("maxAge")
    private Integer maxAge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("epochDate")
    public Integer getEpochDate() {
        return epochDate;
    }

    @JsonProperty("epochDate")
    public void setEpochDate(Integer epochDate) {
        this.epochDate = epochDate;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    @JsonProperty("edgarUrl")
    public URI getEdgarUrl() {
        return edgarUrl;
    }

    @JsonProperty("edgarUrl")
    public void setEdgarUrl(URI edgarUrl) {
        this.edgarUrl = edgarUrl;
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
