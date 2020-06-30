
package ru.levelup.covid19.finance.dto.yahoo.stock.profile;

import java.net.URI;
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
    "zip",
    "sector",
    "fullTimeEmployees",
    "longBusinessSummary",
    "city",
    "phone",
    "compensationAsOfEpochDate",
    "country",
    "companyOfficers",
    "website",
    "maxAge",
    "address1",
    "industry",
    "address2"
})
public class AssetProfile {

    @JsonProperty("zip")
    private String zip;
    @JsonProperty("sector")
    private String sector;
    @JsonProperty("fullTimeEmployees")
    private Integer fullTimeEmployees;
    @JsonProperty("longBusinessSummary")
    private String longBusinessSummary;
    @JsonProperty("city")
    private String city;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("compensationAsOfEpochDate")
    private Integer compensationAsOfEpochDate;
    @JsonProperty("country")
    private String country;
    @JsonProperty("companyOfficers")
    private List<CompanyOfficer> companyOfficers = null;
    @JsonProperty("website")
    private URI website;
    @JsonProperty("maxAge")
    private Integer maxAge;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("industry")
    private String industry;
    @JsonProperty("address2")
    private String address2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("zip")
    public String  getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    @JsonProperty("sector")
    public String getSector() {
        return sector;
    }

    @JsonProperty("sector")
    public void setSector(String sector) {
        this.sector = sector;
    }

    @JsonProperty("fullTimeEmployees")
    public Integer getFullTimeEmployees() {
        return fullTimeEmployees;
    }

    @JsonProperty("fullTimeEmployees")
    public void setFullTimeEmployees(Integer fullTimeEmployees) {
        this.fullTimeEmployees = fullTimeEmployees;
    }

    @JsonProperty("longBusinessSummary")
    public String getLongBusinessSummary() {
        return longBusinessSummary;
    }

    @JsonProperty("longBusinessSummary")
    public void setLongBusinessSummary(String longBusinessSummary) {
        this.longBusinessSummary = longBusinessSummary;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("compensationAsOfEpochDate")
    public Integer getCompensationAsOfEpochDate() {
        return compensationAsOfEpochDate;
    }

    @JsonProperty("compensationAsOfEpochDate")
    public void setCompensationAsOfEpochDate(Integer compensationAsOfEpochDate) {
        this.compensationAsOfEpochDate = compensationAsOfEpochDate;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("companyOfficers")
    public List<CompanyOfficer> getCompanyOfficers() {
        return companyOfficers;
    }

    @JsonProperty("companyOfficers")
    public void setCompanyOfficers(List<CompanyOfficer> companyOfficers) {
        this.companyOfficers = companyOfficers;
    }

    @JsonProperty("website")
    public URI getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(URI website) {
        this.website = website;
    }

    @JsonProperty("maxAge")
    public Integer getMaxAge() {
        return maxAge;
    }

    @JsonProperty("maxAge")
    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @JsonProperty("address1")
    public String getAddress1() {
        return address1;
    }

    @JsonProperty("address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonProperty("industry")
    public String getIndustry() {
        return industry;
    }

    @JsonProperty("industry")
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @JsonProperty("address2")
    public String getAddress2() {
        return address2;
    }

    @JsonProperty("address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
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
