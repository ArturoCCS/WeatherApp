package com.arturoccs.model;

public class Data {
    private City city;
    private long dt; 
    private Temp temp;
    private double speed;
    private double humidity;
    private double rain;

    public Data(long dt, Temp temp, double speed, double humidity, double rain) {
        this.dt = dt;
        this.temp = temp;
        this.speed = speed;
        this.humidity = humidity;
        this.rain = rain;

    }
    
    public Data(String nameCity, float lat, float lon, long date, double temperature, double rain, double windSpeed, double humidity) {
        this.city = new City(nameCity, new Coord(lon, lat));
        this.dt = date;
        this.temp = new Temp(temperature);
        this.rain = rain;
        this.speed = windSpeed;
        this.humidity = humidity;

    }



    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
      }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Data [city=" + city + ", dt=" + dt + ", temp=" + temp + ", speed=" + speed + ", humidity=" + humidity + ", rain=" + rain + "]";
    }
}
