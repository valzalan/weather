package com.valzalan.weather.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.valzalan.weather.api.endpoints.GetForecastEndpoint;
import com.valzalan.weather.api.network.RetrofitClient;
import com.valzalan.weather.api.responses.CurrentWeatherData;
import com.valzalan.weather.api.responses.DailyWeather;
import com.valzalan.weather.api.responses.DailyWeatherData;
import com.valzalan.weather.api.responses.ForecastResponse;
import com.valzalan.weather.api.responses.HourlyWeatherData;
import com.valzalan.weather.enums.DayOfWeek;
import com.valzalan.weather.enums.WeatherType;
import com.valzalan.weather.models.ForecastModel;
import com.valzalan.weather.models.LocationModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private static final String TAG = "Repository";
    private Repository instance = new Repository();
    private LocationModel location;
    private Date time;

    private final String API_KEY = "48f93f8337d0b5b9dcb351c452a7fc38";
    private final double BUD_LAT = 47.4979;
    private final double BUD_LONG = 19.0402;

    private Repository() {
        GetForecastEndpoint endpoint = RetrofitClient.getRetrofitInstance().create(GetForecastEndpoint.class);
        Call<ForecastResponse> call = endpoint.getForecast(API_KEY, BUD_LAT, BUD_LONG);
        call.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(@NonNull Call<ForecastResponse> call, @NonNull Response<ForecastResponse> response) {
                Log.d(TAG, "Success");

                Log.d(TAG, response.body().getTimezone());
                Log.d(TAG, response.body().getDailyWeather().getSummary());
            }

            @Override
            public void onFailure(@NonNull Call<ForecastResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "Error");
                Log.e(TAG, t.getMessage());
            }
        });
    }

    public Repository getInstance(){
        return instance;
    }
}
