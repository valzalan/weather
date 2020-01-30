package com.valzalan.weather.api.responses.custom;

import com.google.gson.annotations.SerializedName;
import com.valzalan.weather.api.responses.Alert;

import java.util.List;

public class ForecastResponse {
    private Location location;
    @SerializedName("currently")
    private CurrentWeatherData currentWeather;
    @SerializedName("minutely")
    private WeatherDataHeader<MinutelyWeatherData> minutelyWeather;
    @SerializedName("hourly")
    private WeatherDataHeader<HourlyWeatherData> hourlyWeatherData;
    @SerializedName("daily")
    private WeatherDataHeader<DailyWeatherData> dailyWeather;
    @SerializedName("alerts")
    private List<Alert> alerts;

    public ForecastResponse(Location location, CurrentWeatherData currentWeather, WeatherDataHeader<MinutelyWeatherData> minutelyWeather,
                            WeatherDataHeader<HourlyWeatherData> hourlyWeatherData, WeatherDataHeader<DailyWeatherData> dailyWeather,
                            List<Alert> alerts) {

        this.location = location;
        this.currentWeather = currentWeather;
        this.minutelyWeather = minutelyWeather;
        this.hourlyWeatherData = hourlyWeatherData;
        this.dailyWeather = dailyWeather;
        this.alerts = alerts;
    }

    public Location getLocation() {
        return location;
    }

    public CurrentWeatherData getCurrentWeather() {
        return currentWeather;
    }

    public WeatherDataHeader<MinutelyWeatherData> getMinutelyWeather() {
        return minutelyWeather;
    }

    public WeatherDataHeader<HourlyWeatherData> getHourlyWeatherData() {
        return hourlyWeatherData;
    }

    public WeatherDataHeader<DailyWeatherData> getDailyWeather() {
        return dailyWeather;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }
}
