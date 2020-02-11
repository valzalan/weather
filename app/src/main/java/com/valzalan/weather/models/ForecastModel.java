package com.valzalan.weather.models;

import com.valzalan.weather.enums.DayOfWeek;
import com.valzalan.weather.enums.WeatherType;
import com.valzalan.weather.utilities.Util;

public class ForecastModel {
    private DayOfWeek day;
    private int precipitation;
    private WeatherType weatherType;
    private int tempMax;
    private int tempMin;

    public ForecastModel(DayOfWeek day, int precipitation, WeatherType weatherType, int tempMax, int tempMin) {
        this.day = day;
        this.precipitation = precipitation;
        this.weatherType = weatherType;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public int getTempMax() {
        return Util.getTempInActiveUnit(tempMax);
    }

    public int getTempMin() {
        return Util.getTempInActiveUnit(tempMin);
    }
}
