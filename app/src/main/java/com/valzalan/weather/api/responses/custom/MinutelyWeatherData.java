package com.valzalan.weather.api.responses.custom;

import com.google.gson.annotations.SerializedName;
import com.valzalan.weather.api.responses.custom.precipitation.PrecipitationData;

public class MinutelyWeatherData {
    @SerializedName("time")
    private long time;
    private PrecipitationData precipitationData;

    public MinutelyWeatherData(long time, PrecipitationData precipitationData) {
        this.time = time;
        this.precipitationData = precipitationData;
    }

    public long getTime() {
        return time;
    }

    public PrecipitationData getPrecipitationData() {
        return precipitationData;
    }
}
