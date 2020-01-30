package com.valzalan.weather.api.responses.custom;

import com.google.gson.annotations.SerializedName;
import com.valzalan.weather.api.responses.custom.precipitation.PrecipitationData;

public class CurrentWeatherData {
    @SerializedName("time")
    private long time;
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("nearestStormDistance")
    private double nearestStormDistance;
    private PrecipitationData precipitationData;
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
    private WindData windData;
    @SerializedName("cloudCover")
    private double cloudCover;
    @SerializedName("uvIndex")
    private double uvIndex;
    @SerializedName("visibility")
    private double visibility;
    @SerializedName("ozone")
    private double ozone;

    public CurrentWeatherData(long time, String summary, String icon, double nearestStormDistance,
                              PrecipitationData precipitationData, double temperature, double apparentTemperature,
                              double dewPoint, double humidity, double pressure, WindData windData,
                              double cloudCover, double uvIndex, double visibility, double ozone) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.nearestStormDistance = nearestStormDistance;
        this.precipitationData = precipitationData;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windData = windData;
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

    public PrecipitationData getPrecipitationData() {
        return precipitationData;
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

    public WindData getWindData() {
        return windData;
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
