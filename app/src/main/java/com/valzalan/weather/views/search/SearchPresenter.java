package com.valzalan.weather.views.search;

public interface SearchPresenter {
    void viewPaused();
    void viewResumed();
    void onInputChanged(String input);
}
