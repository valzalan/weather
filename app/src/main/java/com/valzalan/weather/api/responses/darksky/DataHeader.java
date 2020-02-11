package com.valzalan.weather.api.responses.darksky;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataHeader<T> {
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;
    @SerializedName("data")
    private List<T> data;

    public DataHeader(String summary, String icon, List<T> data) {
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

    public List<T> getData() {
        return data;
    }
}
