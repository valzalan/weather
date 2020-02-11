package com.valzalan.weather.views.main;

import com.valzalan.weather.models.WeatherModel;
import com.valzalan.weather.repository.Repository;
import com.valzalan.weather.repository.WeatherObserver;

public class BasicMainPresenter implements MainPresenter, WeatherObserver {
    private MainView view;
    private Repository repository;

    BasicMainPresenter(MainView view) {
        this.view = view;
        repository = Repository.getInstance();
        repository.registerWeatherObserver(this);
    }

    @Override
    public void onWeatherDataChanged(WeatherModel model) {
        view.update(model);
    }

    @Override
    public void viewPaused() {
        repository.removeWeatherObserver(this);
    }

    @Override
    public void viewResumed() {
        repository.registerWeatherObserver(this);
    }
}
