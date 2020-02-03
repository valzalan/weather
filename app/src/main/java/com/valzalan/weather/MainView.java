package com.valzalan.weather;

import com.valzalan.weather.models.WeatherModel;

public interface MainView {
    void update(WeatherModel model);
    void startSearchView();
    void startDetailsView();
}
