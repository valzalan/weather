package com.valzalan.weather;

import com.valzalan.weather.models.WeatherModel;
import com.valzalan.weather.repository.Repository;
import com.valzalan.weather.repository.RepositoryObserver;

public class BasicMainPresenter implements MainPresenter, RepositoryObserver {
    private MainView view;
    private Repository repository;

    BasicMainPresenter(MainView view) {
        this.view = view;
        repository = Repository.getInstance();
        repository.registerObserver(this);
    }

    @Override
    public void onWeatherDataChanged(WeatherModel model) {
        view.update(model);
    }

    @Override
    public void viewPaused() {
        repository.removeObserver(this);
    }

    @Override
    public void viewResumed() {
        repository.registerObserver(this);
    }
}
