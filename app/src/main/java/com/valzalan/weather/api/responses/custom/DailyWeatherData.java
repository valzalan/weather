package com.valzalan.weather.api.responses.custom;

import com.google.gson.annotations.SerializedName;
import com.valzalan.weather.api.responses.custom.precipitation.PrecipitationData;

public class DailyWeatherData {
    @SerializedName("time")
    private long time;
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("sunriseTime")
    private long sunriseTime;
    @SerializedName("sunsetTime")
    private long sunsetTime;
    @SerializedName("moonPhase")
    private double moonPhase;
    private PrecipitationData precipitationData;
    private TemperatureData temperatureData;
    private TemperatureData apparentTemperatureData;
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
    @SerializedName("uvIndexTime")
    private long uvIndexTime;
    @SerializedName("visibility")
    private double visibility;
    @SerializedName("ozone")
    private double ozone;

    public DailyWeatherData(long time, String summary, String icon, long sunriseTime, long sunsetTime,
                            double moonPhase, PrecipitationData precipitationData, TemperatureData apparentTemperatureData,
                            TemperatureData temperatureData, double dewPoint, double humidity,
                            double pressure, WindData windData, double cloudCover, double uvIndex,
                            long uvIndexTime, double visibility, double ozone) {

        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonPhase = moonPhase;
        this.precipitationData = precipitationData;
        this.temperatureData = temperatureData;
        this.apparentTemperatureData = apparentTemperatureData;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windData = windData;
        this.cloudCover = cloudCover;
        this.uvIndex = uvIndex;
        this.uvIndexTime = uvIndexTime;
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

    public long getSunriseTime() {
        return sunriseTime;
    }

    public long getSunsetTime() {
        return sunsetTime;
    }

    public double getMoonPhase() {
        return moonPhase;
    }

    public PrecipitationData getPrecipitationData() {
        return precipitationData;
    }

    public TemperatureData getTemperatureData() {
        return temperatureData;
    }

    public TemperatureData getApparentTemperatureData() {
        return apparentTemperatureData;
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

    public long getUvIndexTime() {
        return uvIndexTime;
    }

    public double getVisibility() {
        return visibility;
    }

    public double getOzone() {
        return ozone;
    }
}
