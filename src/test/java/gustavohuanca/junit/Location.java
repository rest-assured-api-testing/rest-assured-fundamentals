package gustavohuanca.junit;

import java.util.List;

public class Location {
    private String postConde;
    private String country;
    private String countryAbbreviation;
    private List<Place> places;

    public String getPostConde() {
        return postConde;
    }

    public void setPostConde(String postConde) {
        this.postConde = postConde;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Location (){

    }
}
