package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

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
    private Alert[] alerts;

    public ForecastResponse(double latitude, double longitude, String timezone, CurrentWeatherData currentWeather,
                            MinutelyWeather minutelyWeather, HourlyWeather hourlyWeatherData,
                            DailyWeather dailyWeather, Alert[] alerts) {

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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public CurrentWeatherData getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeatherData currentWeather) {
        this.currentWeather = currentWeather;
    }

    public MinutelyWeather getMinutelyWeather() {
        return minutelyWeather;
    }

    public void setMinutelyWeather(MinutelyWeather minutelyWeather) {
        this.minutelyWeather = minutelyWeather;
    }

    public HourlyWeather getHourlyWeatherData() {
        return hourlyWeatherData;
    }

    public void setHourlyWeatherData(HourlyWeather hourlyWeatherData) {
        this.hourlyWeatherData = hourlyWeatherData;
    }

    public DailyWeather getDailyWeather() {
        return dailyWeather;
    }

    public void setDailyWeather(DailyWeather dailyWeather) {
        this.dailyWeather = dailyWeather;
    }

    public Alert[] getAlerts() {
        return alerts;
    }

    public void setAlerts(Alert[] alerts) {
        this.alerts = alerts;
    }
}
