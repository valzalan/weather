package com.valzalan.weather.models;

import com.valzalan.weather.enums.WeatherType;

import java.util.List;

public class LocationModel {
    private String name;
    private WeatherType weatherType;
    private int temp;
    private int tempMax;
    private int tempMin;
    private List<Integer> tempNextSixHours;
    private int apparentTemp;
    private int windSpeed;
    private int humidity;
    private double pressure;
    private double visibility;
    private int dewPoint;
    private List<Integer> precipicationForecast;
    private List<ForecastModel> nextSevenDaysForecast;

    public LocationModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(WeatherType weatherType) {
        this.weatherType = weatherType;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public List<Integer> getTempNextSixHours() {
        return tempNextSixHours;
    }

    public void setTempNextSixHours(List<Integer> tempNextSixHours) {
        this.tempNextSixHours = tempNextSixHours;
    }

    public int getApparentTemp() {
        return apparentTemp;
    }

    public void setApparentTemp(int apparentTemp) {
        this.apparentTemp = apparentTemp;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public int getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(int dewPoint) {
        this.dewPoint = dewPoint;
    }

    public List<ForecastModel> getNextSevenDaysForecast() {
        return nextSevenDaysForecast;
    }

    public void setNextSevenDaysForecast(List<ForecastModel> nextSevenDaysForecast) {
        this.nextSevenDaysForecast = nextSevenDaysForecast;
    }

    public List<Integer> getPrecipicationForecast() {
        return precipicationForecast;
    }

    public void setPrecipicationForecast(List<Integer> precipicationForecast) {
        this.precipicationForecast = precipicationForecast;
    }
}
