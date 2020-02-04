package com.valzalan.weather.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.valzalan.weather.api.endpoints.GetForecastEndpoint;
import com.valzalan.weather.api.network.RetrofitClient;
import com.valzalan.weather.api.responses.ForecastResponse;
import com.valzalan.weather.enums.DistanceUnit;
import com.valzalan.weather.enums.PressureUnit;
import com.valzalan.weather.enums.SpeedUnit;
import com.valzalan.weather.enums.TemperatureUnit;
import com.valzalan.weather.models.WeatherModel;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.valzalan.weather.enums.DistanceUnit.KILOMETERS;
import static com.valzalan.weather.enums.DistanceUnit.MILES;
import static com.valzalan.weather.enums.PressureUnit.HECTOPASCALS;
import static com.valzalan.weather.enums.PressureUnit.MILLIBARS;
import static com.valzalan.weather.enums.SpeedUnit.KILOMETERS_PER_HOUR;
import static com.valzalan.weather.enums.SpeedUnit.MILES_PER_HOUR;
import static com.valzalan.weather.enums.TemperatureUnit.CELSIUS;
import static com.valzalan.weather.enums.TemperatureUnit.FAHRENHEIT;

public class Repository implements Subject, Callback<ForecastResponse>{
    private static final String TAG = "Repository";
    private static Repository instance = new Repository();
    private ArrayList<RepositoryObserver> observers = new ArrayList<>();
    private WeatherModel weatherModel;
    private TemperatureUnit activeTempUnit = CELSIUS;
    private TemperatureUnit APITempUnit = FAHRENHEIT;
    private SpeedUnit activeSpeedUnit = KILOMETERS_PER_HOUR;
    private SpeedUnit APISpeedUnit = MILES_PER_HOUR;
    private PressureUnit activePressureUnit = HECTOPASCALS;
    private PressureUnit APIPressureUnit = MILLIBARS;
    private DistanceUnit activeDistanceUnit = KILOMETERS;
    private DistanceUnit APIDistanceUnit = MILES;

    private Date time;

    @SuppressWarnings("FieldCanBeLocal")
    private final String API_KEY = "48f93f8337d0b5b9dcb351c452a7fc38";
    @SuppressWarnings("FieldCanBeLocal")
    private final double BUD_LAT = 47.4979;
    @SuppressWarnings("FieldCanBeLocal")
    private final double BUD_LONG = 19.0402;

    private Repository() {
        weatherModel = new WeatherModel();
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

    public WeatherModel getWeatherModel(){
        return this.weatherModel;
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

    public TemperatureUnit getActiveTempUnit() {
        return activeTempUnit;
    }

    public void setActiveTempUnit(TemperatureUnit tempUnit) {
        this.activeTempUnit = tempUnit;
    }

    public TemperatureUnit getAPITempUnit() {
        return APITempUnit;
    }

    public SpeedUnit getActiveSpeedUnit() {
        return activeSpeedUnit;
    }

    public void setActiveSpeedUnit(SpeedUnit speedUnit) {
        this.activeSpeedUnit = speedUnit;
    }

    public SpeedUnit getAPISpeedUnit() {
        return APISpeedUnit;
    }

    public PressureUnit getActivePressureUnit() {
        return activePressureUnit;
    }

    public void setActivePressureUnit(PressureUnit activePressureUnit) {
        this.activePressureUnit = activePressureUnit;
    }

    public PressureUnit getAPIPressureUnit() {
        return APIPressureUnit;
    }

    public DistanceUnit getActiveDistanceUnit() {
        return activeDistanceUnit;
    }

    public void setActiveDistanceUnit(DistanceUnit activeDistanceUnit) {
        this.activeDistanceUnit = activeDistanceUnit;
    }

    public DistanceUnit getAPIDistanceUnit() {
        return APIDistanceUnit;
    }
}
