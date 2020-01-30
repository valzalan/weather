package com.valzalan.weather.api.responses.custom.precipitation;

import com.google.gson.annotations.SerializedName;

public class PrecipitationData {
    @SerializedName("precipIntensity")
    private double precipIntensity;
    @SerializedName("precipIntensityError")
    private double precipIntensityError;
    @SerializedName("precipProbability")
    private double precipProbability;
    @SerializedName("precipType")
    private String precipType;
    @SerializedName("precipIntensityMax")
    private double precipIntensityMax;
    @SerializedName("precipIntensityMaxTime")
    private long precipIntensityMaxTime;

    PrecipitationData(){}

    void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    void setPrecipIntensityError(double precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
    }

    void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    void setPrecipIntensityMax(double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    void setPrecipIntensityMaxTime(long precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
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

    public double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public long getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }
}
