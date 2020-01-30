package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyWeather {
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("data")
    private List<DailyWeatherData> data;

    public DailyWeather(String summary, String icon, List<DailyWeatherData> data) {
        this.summary = summary;
        this.icon = icon;
        this.data = data;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public List<DailyWeatherData> getData() {
        return data;
    }
}
