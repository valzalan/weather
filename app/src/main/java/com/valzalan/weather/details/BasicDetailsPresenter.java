package com.valzalan.weather.details;

public class BasicDetailsPresenter implements DetailsPresenter {
    private DetailsView view;

    public BasicDetailsPresenter(DetailsView view) {
        this.view = view;
    }
}