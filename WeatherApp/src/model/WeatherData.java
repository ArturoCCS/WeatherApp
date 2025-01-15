package model;

import java.util.List;

public class WeatherData {
    private City city;
    private List<Data> data;

    public WeatherData() {
    }

    public WeatherData(List<Data> data, City city) {
        this.city = city;
        this.data = data;
    }

    public void assignCity() {
        for (Data d : data) {
            d.setCity(city);
        }
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Data> getRecords() {
        return data;
    }

    public void setRecords(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "City: " + city.toString() + "\nRecords:\n" + data;
    }
}
