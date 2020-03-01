package com.valzalan.weather.views.search;

import com.valzalan.weather.api.responses.google.places.Prediction;
import com.valzalan.weather.repository.PlaceObserver;
import com.valzalan.weather.repository.Repository;

import java.util.ArrayList;
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
    public void onDetailsResponse() {
        view.back();
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
        //view.updateList(getMockLocationList());
        repository.getLocationPredictions(input);
    }

    @Override
    public void onSearchItemClick(String placeId) {
        repository.getPlaceDetails(placeId);
    }

    private List<Prediction> getMockLocationList() {
        List<Prediction> res = new ArrayList<>();
        res.add(new Prediction("Paris", "0"));
        res.add(new Prediction("New York", "0"));
        res.add(new Prediction("Shanghai", "0"));
        res.add(new Prediction("Washington", "0"));
        res.add(new Prediction("Budapest", "0"));
        res.add(new Prediction("Copenhagen", "0"));
        return res;
    }
}
