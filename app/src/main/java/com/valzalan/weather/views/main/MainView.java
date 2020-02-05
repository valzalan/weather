package com.valzalan.weather.views.main;

import com.valzalan.weather.models.WeatherModel;

public interface MainView {
    void update(WeatherModel model);
    void startSearchView();
}
