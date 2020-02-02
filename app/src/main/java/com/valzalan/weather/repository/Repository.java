package com.valzalan.weather.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.valzalan.weather.api.endpoints.GetForecastEndpoint;
import com.valzalan.weather.api.network.RetrofitClient;
import com.valzalan.weather.api.responses.ForecastResponse;
import com.valzalan.weather.models.WeatherModel;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements Subject, Callback<ForecastResponse>{
    private static final String TAG = "Repository";
    private static Repository instance = new Repository();
    private ArrayList<RepositoryObserver> observers = new ArrayList<>();
    private WeatherModel weatherModel;
    private Date time;

    @SuppressWarnings("FieldCanBeLocal")
    private final String API_KEY = "48f93f8337d0b5b9dcb351c452a7fc38";
    @SuppressWarnings("FieldCanBeLocal")
    private final double BUD_LAT = 47.4979;
    @SuppressWarnings("FieldCanBeLocal")
    private final double BUD_LONG = 19.0402;

    private Repository() {
        getWeather(BUD_LAT, BUD_LONG);
    }

    public static Repository getInstance(){
        return instance;
    }

    private void getWeather(double lat, double lon){
        GetForecastEndpoint endpoint = RetrofitClient.getRetrofitInstance().create(GetForecastEndpoint.class);
        Call<ForecastResponse> call = endpoint.getForecast(API_KEY, lat, lon);
        call.enqueue(this);
    }

    @Override
    public void registerObserver(RepositoryObserver repositoryObserver) {
        if(!observers.contains(repositoryObserver)) {
            observers.add(repositoryObserver);
        }
    }

    @Override
    public void removeObserver(RepositoryObserver repositoryObserver) {
        observers.remove(repositoryObserver);
    }

    @Override
    public void notifyObservers() {
        for (RepositoryObserver observer: observers) {
            observer.onWeatherDataChanged(weatherModel);
        }
    }

    @Override
    public void onResponse(@NonNull Call<ForecastResponse> call, Response<ForecastResponse> response) {
        Log.d(TAG, "Success");
        if(response.body() != null){
            weatherModel = new WeatherModel(response.body());
            notifyObservers();
        }
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onFailure(@NonNull Call<ForecastResponse> call, Throwable t) {
        Log.e(TAG, "Error");
        Log.e(TAG, t.getMessage());
    }
}
