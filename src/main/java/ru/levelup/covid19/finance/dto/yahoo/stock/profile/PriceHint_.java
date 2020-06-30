
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
    "raw",
    "fmt",
    "longFmt"
})
public class PriceHint_ {

    @JsonProperty("raw")
    private Integer raw;
    @JsonProperty("fmt")
    private Long fmt;
    @JsonProperty("longFmt")
    private Long longFmt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("raw")
    public Integer getRaw() {
        return raw;
    }

    @JsonProperty("raw")
    public void setRaw(Integer raw) {
        this.raw = raw;
    }

    @JsonProperty("fmt")
    public Long getFmt() {
        return fmt;
    }

    @JsonProperty("fmt")
    public void setFmt(Long fmt) {
        this.fmt = fmt;
    }

    @JsonProperty("longFmt")
    public Long getLongFmt() {
        return longFmt;
    }

    @JsonProperty("longFmt")
    public void setLongFmt(Long longFmt) {
        this.longFmt = longFmt;
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
