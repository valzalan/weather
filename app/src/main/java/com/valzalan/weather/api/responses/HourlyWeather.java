package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HourlyWeather {
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("data")
    private List<HourlyWeatherData> data;

    public HourlyWeather(String summary, String icon, List<HourlyWeatherData> data) {
        this.summary = summary;
        this.icon = icon;
        this.data = data;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<HourlyWeatherData> getData() {
        return data;
    }

    public void setData(List<HourlyWeatherData> data) {
        this.data = data;
    }
}
