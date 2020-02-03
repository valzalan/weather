package com.valzalan.weather.repository;

import com.valzalan.weather.models.WeatherModel;

public interface RepositoryObserver {
    void onWeatherDataChanged(WeatherModel model);
}
