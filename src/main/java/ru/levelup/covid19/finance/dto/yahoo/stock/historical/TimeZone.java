
package ru.levelup.covid19.finance.dto.yahoo.stock.historical;

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
        "gmtOffset"
})
public class TimeZone {

    @JsonProperty("gmtOffset")
    private Integer gmtOffset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("gmtOffset")
    public Integer getGmtOffset() {
        return gmtOffset;
    }

    @JsonProperty("gmtOffset")
    public void setGmtOffset(Integer gmtOffset) {
        this.gmtOffset = gmtOffset;
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
