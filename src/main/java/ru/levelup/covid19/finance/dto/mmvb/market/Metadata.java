
package ru.levelup.covid19.finance.dto.mmvb.market;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import ru.levelup.covid19.finance.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BOARDID",
    "SECID",
    "TRADEDATE",
    "SHORTNAME",
    "NAME",
    "CLOSE",
    "OPEN",
    "HIGH",
    "LOW",
    "VALUE",
    "DURATION",
    "YIELD",
    "DECIMALS",
    "CAPITALIZATION",
    "CURRENCYID",
    "DIVISOR"
})
public class Metadata {

    @JsonProperty("BOARDID")
    private BOARDID bOARDID;
    @JsonProperty("SECID")
    private SECID sECID;
    @JsonProperty("TRADEDATE")
    private TRADEDATE tRADEDATE;
    @JsonProperty("SHORTNAME")
    private SHORTNAME sHORTNAME;
    @JsonProperty("NAME")
    private NAME nAME;
    @JsonProperty("CLOSE")
    private CLOSE cLOSE;
    @JsonProperty("OPEN")
    private OPEN oPEN;
    @JsonProperty("HIGH")
    private HIGH hIGH;
    @JsonProperty("LOW")
    private LOW lOW;
    @JsonProperty("VALUE")
    private VALUE vALUE;
    @JsonProperty("DURATION")
    private DURATION dURATION;
    @JsonProperty("YIELD")
    private YIELD yIELD;
    @JsonProperty("DECIMALS")
    private DECIMALS dECIMALS;
    @JsonProperty("CAPITALIZATION")
    private CAPITALIZATION cAPITALIZATION;
    @JsonProperty("CURRENCYID")
    private CURRENCYID cURRENCYID;
    @JsonProperty("DIVISOR")
    private DIVISOR dIVISOR;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("BOARDID")
    public BOARDID getBOARDID() {
        return bOARDID;
    }

    @JsonProperty("BOARDID")
    public void setBOARDID(BOARDID bOARDID) {
        this.bOARDID = bOARDID;
    }

    @JsonProperty("SECID")
    public SECID getSECID() {
        return sECID;
    }

    @JsonProperty("SECID")
    public void setSECID(SECID sECID) {
        this.sECID = sECID;
    }

    @JsonProperty("TRADEDATE")
    public TRADEDATE getTRADEDATE() {
        return tRADEDATE;
    }

    @JsonProperty("TRADEDATE")
    public void setTRADEDATE(TRADEDATE tRADEDATE) {
        this.tRADEDATE = tRADEDATE;
    }

    @JsonProperty("SHORTNAME")
    public SHORTNAME getSHORTNAME() {
        return sHORTNAME;
    }

    @JsonProperty("SHORTNAME")
    public void setSHORTNAME(SHORTNAME sHORTNAME) {
        this.sHORTNAME = sHORTNAME;
    }

    @JsonProperty("NAME")
    public NAME getNAME() {
        return nAME;
    }

    @JsonProperty("NAME")
    public void setNAME(NAME nAME) {
        this.nAME = nAME;
    }

    @JsonProperty("CLOSE")
    public CLOSE getCLOSE() {
        return cLOSE;
    }

    @JsonProperty("CLOSE")
    public void setCLOSE(CLOSE cLOSE) {
        this.cLOSE = cLOSE;
    }

    @JsonProperty("OPEN")
    public OPEN getOPEN() {
        return oPEN;
    }

    @JsonProperty("OPEN")
    public void setOPEN(OPEN oPEN) {
        this.oPEN = oPEN;
    }

    @JsonProperty("HIGH")
    public HIGH getHIGH() {
        return hIGH;
    }

    @JsonProperty("HIGH")
    public void setHIGH(HIGH hIGH) {
        this.hIGH = hIGH;
    }

    @JsonProperty("LOW")
    public LOW getLOW() {
        return lOW;
    }

    @JsonProperty("LOW")
    public void setLOW(LOW lOW) {
        this.lOW = lOW;
    }

    @JsonProperty("VALUE")
    public VALUE getVALUE() {
        return vALUE;
    }

    @JsonProperty("VALUE")
    public void setVALUE(VALUE vALUE) {
        this.vALUE = vALUE;
    }

    @JsonProperty("DURATION")
    public DURATION getDURATION() {
        return dURATION;
    }

    @JsonProperty("DURATION")
    public void setDURATION(DURATION dURATION) {
        this.dURATION = dURATION;
    }

    @JsonProperty("YIELD")
    public YIELD getYIELD() {
        return yIELD;
    }

    @JsonProperty("YIELD")
    public void setYIELD(YIELD yIELD) {
        this.yIELD = yIELD;
    }

    @JsonProperty("DECIMALS")
    public DECIMALS getDECIMALS() {
        return dECIMALS;
    }

    @JsonProperty("DECIMALS")
    public void setDECIMALS(DECIMALS dECIMALS) {
        this.dECIMALS = dECIMALS;
    }

    @JsonProperty("CAPITALIZATION")
    public CAPITALIZATION getCAPITALIZATION() {
        return cAPITALIZATION;
    }

    @JsonProperty("CAPITALIZATION")
    public void setCAPITALIZATION(CAPITALIZATION cAPITALIZATION) {
        this.cAPITALIZATION = cAPITALIZATION;
    }

    @JsonProperty("CURRENCYID")
    public CURRENCYID getCURRENCYID() {
        return cURRENCYID;
    }

    @JsonProperty("CURRENCYID")
    public void setCURRENCYID(CURRENCYID cURRENCYID) {
        this.cURRENCYID = cURRENCYID;
    }

    @JsonProperty("DIVISOR")
    public DIVISOR getDIVISOR() {
        return dIVISOR;
    }

    @JsonProperty("DIVISOR")
    public void setDIVISOR(DIVISOR dIVISOR) {
        this.dIVISOR = dIVISOR;
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
