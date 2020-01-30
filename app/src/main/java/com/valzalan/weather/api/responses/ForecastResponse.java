package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastResponse {
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longitude")
    private double longitude;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("currently")
    private CurrentWeatherData currentWeather;
    @SerializedName("minutely")
    private MinutelyWeather minutelyWeather;
    @SerializedName("hourly")
    private HourlyWeather hourlyWeatherData;
    @SerializedName("daily")
    private DailyWeather dailyWeather;
    @SerializedName("alerts")
    private List<Alert> alerts;

    public ForecastResponse(double latitude, double longitude, String timezone, CurrentWeatherData currentWeather,
                            MinutelyWeather minutelyWeather, HourlyWeather hourlyWeatherData,
                            DailyWeather dailyWeather, List<Alert> alerts) {

        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.currentWeather = currentWeather;
        this.minutelyWeather = minutelyWeather;
        this.hourlyWeatherData = hourlyWeatherData;
        this.dailyWeather = dailyWeather;
        this.alerts = alerts;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public CurrentWeatherData getCurrentWeather() {
        return currentWeather;
    }

    public MinutelyWeather getMinutelyWeather() {
        return minutelyWeather;
    }

    public HourlyWeather getHourlyWeatherData() {
        return hourlyWeatherData;
    }

    public DailyWeather getDailyWeather() {
        return dailyWeather;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }
}
