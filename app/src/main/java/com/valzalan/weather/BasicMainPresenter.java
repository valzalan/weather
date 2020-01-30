package com.valzalan.weather;

public class BasicMainPresenter implements MainPresenter {
    private MainView view;
    private final String API_KEY = "48f93f8337d0b5b9dcb351c452a7fc38";
    private final double BUD_LAT = 47.4979;
    private final double BUD_LONG = 19.0402;

    public BasicMainPresenter(MainView view) {
        this.view = view;
    }
}
