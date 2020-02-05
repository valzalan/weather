package com.valzalan.weather.api.responses.darksky;

import com.google.gson.annotations.SerializedName;

public class ForecastResponse {
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("currently")
    private CurrentWeatherData currentWeather;
    @SerializedName("hourly")
    private DataHeader<HourlyWeatherData> hourlyWeatherData;
    @SerializedName("daily")
    private DataHeader<DailyWeatherData> dailyWeather;

    public ForecastResponse(String timezone, CurrentWeatherData currentWeather, DataHeader<HourlyWeatherData> hourlyWeatherData,
                            DataHeader<DailyWeatherData> dailyWeather) {

        this.timezone = timezone;
        this.currentWeather = currentWeather;
        this.hourlyWeatherData = hourlyWeatherData;
        this.dailyWeather = dailyWeather;
    }

    public String getTimezone() {
        return timezone;
    }

    public CurrentWeatherData getCurrentWeather() {
        return currentWeather;
    }

    public DataHeader<HourlyWeatherData> getHourlyWeatherData() {
        return hourlyWeatherData;
    }

    public DataHeader<DailyWeatherData> getDailyWeather() {
        return dailyWeather;
    }
}
