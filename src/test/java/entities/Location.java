package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"postCode", "country", "countryAbbreveation", "places"})
public class Location {
    private String postCode;
    private String country;
    private String countryAbbreveation;
    private List<Place> places;

    public Location() {

    }

    @JsonProperty("post code")
    public String getPostCode() {
        return postCode;
    }

    @JsonProperty("post code")
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("country abbreviation")
    public String getCountryAbbreveation() {
        return countryAbbreveation;
    }

    @JsonProperty("country abbreviation")
    public void setCountryAbbreveation(String countryAbbreveation) {
        this.countryAbbreveation = countryAbbreveation;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
