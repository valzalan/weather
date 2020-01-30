package com.valzalan.weather.api.responses.custom;

import com.google.gson.annotations.SerializedName;

public class WindData {
    @SerializedName("windSpeed")
    private double windSpeed;
    @SerializedName("windGust")
    private double windGust;
    @SerializedName("windBearing")
    private double windBearing;
    @SerializedName("windGustTime")
    private long windGustTime;

    public WindData(double windSpeed, double windGust, double windBearing, long windGustTime) {
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windBearing = windBearing;
        this.windGustTime = windGustTime;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public double getWindBearing() {
        return windBearing;
    }

    public long getWindGustTime() {
        return windGustTime;
    }
}
