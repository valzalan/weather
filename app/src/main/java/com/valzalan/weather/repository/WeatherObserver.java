package com.valzalan.weather.repository;

import com.valzalan.weather.models.WeatherModel;

public interface WeatherObserver {
    void onWeatherDataChanged(WeatherModel model);
}
