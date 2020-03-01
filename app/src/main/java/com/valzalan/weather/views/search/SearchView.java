package com.valzalan.weather.views.search;

import com.valzalan.weather.api.responses.google.places.Prediction;

import java.util.List;

public interface SearchView {
    void updateList(List<Prediction> list);
    void back();
}
