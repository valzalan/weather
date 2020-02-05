package com.valzalan.weather.repository;

public interface Subject {
    void registerWeatherObserver(WeatherObserver observer);
    void removeWeatherObserver(WeatherObserver observer);
    void notifyWeatherObservers();

    void registerPlaceObserver(PlaceObserver observer);
    void removePlaceObserver(PlaceObserver observer);
    void notifyPlaceObservers();
}
