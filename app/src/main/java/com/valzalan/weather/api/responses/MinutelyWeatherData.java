package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

public class MinutelyWeatherData {
    @SerializedName("time")
    private long time;
    @SerializedName("precipIntensity")
    private double precipIntensity;
    @SerializedName("precipIntensityError")
    private double precipIntensityError;
    @SerializedName("precipProbability")
    private double precipProbability;
    @SerializedName("precipType")
    private String precipType;

    public MinutelyWeatherData(long time, double precipIntensity, double precipIntensityError,
                               double precipProbability, String precipType) {

        this.time = time;
        this.precipIntensity = precipIntensity;
        this.precipIntensityError = precipIntensityError;
        this.precipProbability = precipProbability;
        this.precipType = precipType;
    }

    public long getTime() {
        return time;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public double getPrecipIntensityError() {
        return precipIntensityError;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }
}
