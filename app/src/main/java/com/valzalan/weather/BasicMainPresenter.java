package com.valzalan.weather;

public class BasicMainPresenter implements MainPresenter {
    private MainView view;

    public BasicMainPresenter(MainView view) {
        this.view = view;
    }
}
