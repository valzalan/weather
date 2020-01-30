package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

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
    @SerializedName("precipIntensityMax")
    private double precipIntensityMax;
    @SerializedName("precipIntensityMaxTime")
    private long precipIntensityMaxTime;
    @SerializedName("precipProbability")
    private double precipProbability;
    @SerializedName("precipType")
    private String precipType;
    @SerializedName("temperatureHigh")
    private double temperatureHigh;
    @SerializedName("temperatureHighTime")
    private long temperatureHighTime;
    @SerializedName("temperatureLow")
    private double temperatureLow;
    @SerializedName("temperatureLowTime")
    private long temperatureLowTime;
    @SerializedName("apparentTemperatureHigh")
    private double apparentTemperatureHigh;
    @SerializedName("apparentTemperatureHighTime")
    private long apparentTemperatureHighTime;
    @SerializedName("apparentTemperatureLow")
    private double apparentTemperatureLow;
    @SerializedName("apparentTemperatureLowTime")
    private long apparentTemperatureLowTime;
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
    @SerializedName("windGustTime")
    private long windGustTime;
    @SerializedName("windBearing")
    private double windBearing;
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
    @SerializedName("temperatureMin")
    private double temperatureMin;
    @SerializedName("temperatureMinTime")
    private long temperatureMinTime;
    @SerializedName("temperatureMax")
    private double temperatureMax;
    @SerializedName("temperatureMaxTime")
    private long temperatureMaxTime;
    @SerializedName("apparentTemperatureMin")
    private double apparentTemperatureMin;
    @SerializedName("apparentTemperatureMinTime")
    private long apparentTemperatureMinTime;
    @SerializedName("apparentTemperatureMax")
    private double apparentTemperatureMax;
    @SerializedName("apparentTemperatureMaxTime")
    private long apparentTemperatureMaxTime;

    public DailyWeatherData(long time, String summary, String icon, long sunriseTime, long sunsetTime,
                            double moonPhase, double precipIntensityMax, long precipIntensityMaxTime,
                            double precipProbability, String precipType, double temperatureHigh,
                            long temperatureHighTime, double temperatureLow, long temperatureLowTime,
                            double apparentTemperatureHigh, long apparentTemperatureHighTime,
                            double apparentTemperatureLow, long apparentTemperatureLowTime,
                            double dewPoint, double humidity, double pressure, double windSpeed,
                            double windGust, long windGustTime, double windBearing, double cloudCover,
                            double uvIndex, long uvIndexTime, double visibility, double ozone,
                            double temperatureMin, long temperatureMinTime, double temperatureMax,
                            long temperatureMaxTime, double apparentTemperatureMin,
                            long apparentTemperatureMinTime, double apparentTemperatureMax,
                            long apparentTemperatureMaxTime) {

        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonPhase = moonPhase;
        this.precipIntensityMax = precipIntensityMax;
        this.precipIntensityMaxTime = precipIntensityMaxTime;
        this.precipProbability = precipProbability;
        this.precipType = precipType;
        this.temperatureHigh = temperatureHigh;
        this.temperatureHighTime = temperatureHighTime;
        this.temperatureLow = temperatureLow;
        this.temperatureLowTime = temperatureLowTime;
        this.apparentTemperatureHigh = apparentTemperatureHigh;
        this.apparentTemperatureHighTime = apparentTemperatureHighTime;
        this.apparentTemperatureLow = apparentTemperatureLow;
        this.apparentTemperatureLowTime = apparentTemperatureLowTime;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windGustTime = windGustTime;
        this.windBearing = windBearing;
        this.cloudCover = cloudCover;
        this.uvIndex = uvIndex;
        this.uvIndexTime = uvIndexTime;
        this.visibility = visibility;
        this.ozone = ozone;
        this.temperatureMin = temperatureMin;
        this.temperatureMinTime = temperatureMinTime;
        this.temperatureMax = temperatureMax;
        this.temperatureMaxTime = temperatureMaxTime;
        this.apparentTemperatureMin = apparentTemperatureMin;
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        this.apparentTemperatureMax = apparentTemperatureMax;
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
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

    public double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public long getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public double getTemperatureHigh() {
        return temperatureHigh;
    }

    public long getTemperatureHighTime() {
        return temperatureHighTime;
    }

    public double getTemperatureLow() {
        return temperatureLow;
    }

    public long getTemperatureLowTime() {
        return temperatureLowTime;
    }

    public double getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }

    public long getApparentTemperatureHighTime() {
        return apparentTemperatureHighTime;
    }

    public double getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }

    public long getApparentTemperatureLowTime() {
        return apparentTemperatureLowTime;
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

    public long getWindGustTime() {
        return windGustTime;
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

    public long getUvIndexTime() {
        return uvIndexTime;
    }

    public double getVisibility() {
        return visibility;
    }

    public double getOzone() {
        return ozone;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public long getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public long getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public long getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public long getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }
}
