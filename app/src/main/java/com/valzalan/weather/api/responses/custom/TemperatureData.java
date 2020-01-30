package com.valzalan.weather.api.responses.custom;

import com.google.gson.annotations.SerializedName;

public class TemperatureData {
    @SerializedName("temperatureHigh")
    private double high;
    @SerializedName("temperatureHighTime")
    private long highTime;
    @SerializedName("temperatureLow")
    private double low;
    @SerializedName("temperatureLowTime")
    private long lowTime;
    @SerializedName("temperatureMin")
    private double min;
    @SerializedName("temperatureMinTime")
    private long minTime;
    @SerializedName("temperatureMax")
    private double max;
    @SerializedName("temperatureMaxTime")
    private long maxTime;

    public TemperatureData(double high, long highTime, double low, long lowTime, double min,
                           long minTime, double max, long maxTime) {

        this.high = high;
        this.highTime = highTime;
        this.low = low;
        this.lowTime = lowTime;
        this.min = min;
        this.minTime = minTime;
        this.max = max;
        this.maxTime = maxTime;
    }

    public double getHigh() {
        return high;
    }

    public long getHighTime() {
        return highTime;
    }

    public double getLow() {
        return low;
    }

    public long getLowTime() {
        return lowTime;
    }

    public double getMin() {
        return min;
    }

    public long getMinTime() {
        return minTime;
    }

    public double getMax() {
        return max;
    }

    public long getMaxTime() {
        return maxTime;
    }
}
