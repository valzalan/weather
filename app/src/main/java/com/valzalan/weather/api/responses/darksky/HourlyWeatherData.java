package com.valzalan.weather.api.responses.darksky;

import com.google.gson.annotations.SerializedName;

public class HourlyWeatherData {
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("precipProbability")
    private double precipProbability;
    @SerializedName("temperature")
    private double temperature;
    @SerializedName("apparentTemperature")
    private double apparentTemperature;
    @SerializedName("dewPoint")
    private double dewPoint;
    @SerializedName("humidity")
    private double humidity;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("windSpeed")
    private double windSpeed;
    @SerializedName("visibility")
    private double visibility;

    public HourlyWeatherData(String summary, String icon, double precipProbability,
                             double temperature, double apparentTemperature, double dewPoint,
                             double humidity, double pressure, double windSpeed, double visibility) {
        this.summary = summary;
        this.icon = icon;
        this.precipProbability = precipProbability;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.visibility = visibility;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getVisibility() {
        return visibility;
    }
}
