package com.valzalan.weather.views.details;

import com.valzalan.weather.models.WeatherModel;
import com.valzalan.weather.repository.Repository;
import com.valzalan.weather.repository.RepositoryObserver;

public class BasicDetailsPresenter implements DetailsPresenter, RepositoryObserver {
    private DetailsView view;
    private Repository repository;

    BasicDetailsPresenter(DetailsView view) {
        this.view = view;
        repository = Repository.getInstance();
        repository.registerObserver(this);
        view.update(repository.getWeatherModel());
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
