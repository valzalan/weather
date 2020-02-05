package com.valzalan.weather.api.responses.darksky;

import com.google.gson.annotations.SerializedName;

public class DailyWeatherData {
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("precipProbability")
    private double precipProbability;
    @SerializedName("temperatureHigh")
    private double temperatureHigh;
    @SerializedName("temperatureLow")
    private double temperatureLow;
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

    public DailyWeatherData(String summary, String icon, double precipProbability,
                            double temperatureHigh, double temperatureLow, double dewPoint,
                            double humidity, double pressure, double windSpeed, double visibility) {

        this.summary = summary;
        this.icon = icon;
        this.precipProbability = precipProbability;
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
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

    public double getTemperatureHigh() {
        return temperatureHigh;
    }

    public double getTemperatureLow() {
        return temperatureLow;
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
