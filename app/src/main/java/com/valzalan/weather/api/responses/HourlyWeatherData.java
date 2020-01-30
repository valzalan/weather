package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

public class HourlyWeatherData {
    @SerializedName("time")
    private long time;//1509993277
    @SerializedName("summary")
    private String summary; // "Drizzle"
    @SerializedName("icon")
    private String icon; //"rain"
    @SerializedName("precipProbability")
    private double precipProbability; //: 0.9,
    @SerializedName("precipType")
    private String precipType; //": "rain",
    @SerializedName("temperature")
    private double temperature; //: 66.1,
    @SerializedName("apparentTemperature")
    private double apparentTemperature; //": 66.31,
    @SerializedName("dewPoint")
    private double dewPoint; //: 60.77,
    @SerializedName("humidity")
    private double humidity; //": 0.83,
    @SerializedName("pressure")
    private double pressure; //": 1010.34,
    @SerializedName("windSpeed")
    private double windSpeed; //": 5.59,
    @SerializedName("windGust")
    private double windGust; //: 12.03,
    @SerializedName("windBearing")
    private double windBearing; //": 246,
    @SerializedName("cloudCover")
    private double cloudCover; //: 0.7,
    @SerializedName("uvIndex")
    private double uvIndex; //: 1,
    @SerializedName("visibility")
    private double visibility; //: 9.84,
    @SerializedName("ozone")
    private double ozone; //: 267.44

    public HourlyWeatherData(long time, String summary, String icon, double precipProbability,
                             String precipType, double temperature, double apparentTemperature,
                             double dewPoint, double humidity, double pressure, double windSpeed,
                             double windGust, double windBearing, double cloudCover, double uvIndex,
                             double visibility, double ozone) {

        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.precipProbability = precipProbability;
        this.precipType = precipType;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windBearing = windBearing;
        this.cloudCover = cloudCover;
        this.uvIndex = uvIndex;
        this.visibility = visibility;
        this.ozone = ozone;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    public double getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(double windBearing) {
        this.windBearing = windBearing;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(double uvIndex) {
        this.uvIndex = uvIndex;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getOzone() {
        return ozone;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }
}
