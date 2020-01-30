package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MinutelyWeather {
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("data")
    private List<MinutelyWeatherData> data;

    public MinutelyWeather(String summary, String icon, List<MinutelyWeatherData> data) {
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

    public List<MinutelyWeatherData> getData() {
        return data;
    }

    public void setData(List<MinutelyWeatherData> data) {
        this.data = data;
    }
}
