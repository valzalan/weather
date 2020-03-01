package com.valzalan.weather.repository;

import com.valzalan.weather.api.responses.google.places.Prediction;

import java.util.List;

public interface PlaceObserver {
    void onPredictionsChanged(List<Prediction> predictions);
    void onDetailsResponse();
}
