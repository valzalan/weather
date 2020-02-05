package com.valzalan.weather.views.search;

import com.valzalan.weather.api.responses.google.places.Prediction;
import com.valzalan.weather.repository.PlaceObserver;
import com.valzalan.weather.repository.Repository;

import java.util.List;

public class BasicSearchPresenter implements SearchPresenter, PlaceObserver {
    private SearchView view;
    private Repository repository;

    public BasicSearchPresenter(SearchView view) {
        this.view = view;
        repository = Repository.getInstance();
    }

    @Override
    public void onPredictionsChanged(List<Prediction> predictions) {
        view.updateList(predictions);
    }

    @Override
    public void viewPaused() {
        repository.removePlaceObserver(this);
    }

    @Override
    public void viewResumed() {
        repository.registerPlaceObserver(this);
    }

    @Override
    public void onInputChanged(String input) {
        repository.getLocationPredictions(input);
    }
}
