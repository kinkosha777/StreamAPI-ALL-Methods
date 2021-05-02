package kg.megacom.models;

import kg.megacom.models.enums.PlacesType;

import java.util.List;
import java.util.Objects;

public class Places {

    private String name;
    private PlacesType placesType;
    private List<Flat> flats;

    public Places() {
    }

    public Places(String name, PlacesType placesType, List<Flat> flats) {
        this.name = name;
        this.placesType = placesType;
        this.flats = flats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlacesType getPlacesType() {
        return placesType;
    }

    public void setPlacesType(PlacesType placesType) {
        this.placesType = placesType;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Places places = (Places) o;
        return Objects.equals(name, places.name) && placesType == places.placesType && Objects.equals(flats, places.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, placesType, flats);
    }

    @Override
    public String toString() {
        return "Places{" +
                "name='" + name + '\'' +
                ", placesType=" + placesType +
                ", flats=" + flats +
                '}';
    }
}
