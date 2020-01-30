package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

public class CurrentWeatherData {
    @SerializedName("time")
    private long time;
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("nearestStormDistance")
    private double nearestStormDistance;
    @SerializedName("precipIntensity")
    private double precipIntensity;
    @SerializedName("precipIntensityError")
    private double precipIntensityError;
    @SerializedName("precipProbability")
    private double precipProbability;
    @SerializedName("precipType")
    private String precipType;
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
    @SerializedName("windGust")
    private double windGust;
    @SerializedName("windBearing")
    private double windBearing;
    @SerializedName("cloudCover")
    private double cloudCover;
    @SerializedName("uvIndex")
    private double uvIndex;
    @SerializedName("visibility")
    private double visibility;
    @SerializedName("ozone")
    private double ozone;

    public CurrentWeatherData(long time, String summary, String icon, double nearestStormDistance,
                              double precipIntensity, double precipIntensityError,
                              double precipProbability, String precipType, double temperature,
                              double apparentTemperature, double dewPoint, double humidity,
                              double pressure, double windSpeed, double windGust, double windBearing,
                              double cloudCover, double uvIndex, double visibility, double ozone) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.nearestStormDistance = nearestStormDistance;
        this.precipIntensity = precipIntensity;
        this.precipIntensityError = precipIntensityError;
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

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public double getNearestStormDistance() {
        return nearestStormDistance;
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

    public double getWindGust() {
        return windGust;
    }

    public double getWindBearing() {
        return windBearing;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public double getUvIndex() {
        return uvIndex;
    }

    public double getVisibility() {
        return visibility;
    }

    public double getOzone() {
        return ozone;
    }
}
