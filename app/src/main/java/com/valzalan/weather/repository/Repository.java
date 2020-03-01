package com.valzalan.weather.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.valzalan.weather.api.endpoints.DarkSkyForecastEndpoint;
import com.valzalan.weather.api.endpoints.GooglePlacesEndpoint;
import com.valzalan.weather.api.network.DarkSkyWeatherClient;
import com.valzalan.weather.api.network.GooglePlacesClient;
import com.valzalan.weather.api.responses.darksky.ForecastResponse;
import com.valzalan.weather.api.responses.google.places.AutocompleteResponse;
import com.valzalan.weather.api.responses.google.places.DetailsResponse;
import com.valzalan.weather.api.responses.google.places.Prediction;
import com.valzalan.weather.enums.DistanceUnit;
import com.valzalan.weather.enums.PressureUnit;
import com.valzalan.weather.enums.SpeedUnit;
import com.valzalan.weather.enums.TemperatureUnit;
import com.valzalan.weather.models.WeatherModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

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

public class Repository implements Subject {
    private static final String TAG = "Repository";
    private static Repository instance = new Repository();
    private List<WeatherObserver> weatherObservers = new ArrayList<>();
    private List<PlaceObserver> placeObservers = new ArrayList<>();
    private WeatherModel weatherModel;
    private List<Prediction> locationPredictions = new ArrayList<>();
    private TemperatureUnit activeTempUnit = CELSIUS;
    private TemperatureUnit APITempUnit = FAHRENHEIT;
    private SpeedUnit activeSpeedUnit = KILOMETERS_PER_HOUR;
    private SpeedUnit APISpeedUnit = MILES_PER_HOUR;
    private PressureUnit activePressureUnit = HECTOPASCALS;
    private PressureUnit APIPressureUnit = MILLIBARS;
    private DistanceUnit activeDistanceUnit = KILOMETERS;
    private DistanceUnit APIDistanceUnit = MILES;
    private String sessionToken;

    @SuppressWarnings("FieldCanBeLocal")
    private final String API_KEY_DARKSKY = "48f93f8337d0b5b9dcb351c452a7fc38";
    private final String API_KEY_GOOGLE = "AIzaSyCjDMuyKIabqNFG_KrNjpWVg-nlqS9feMQ";
    private final double BUD_LAT = 47.4979;
    private final double BUD_LONG = 19.0402;
    @SuppressWarnings("FieldCanBeLocal")
    private final int REFRESH_TIME = 60000;

    private double latitude = BUD_LAT;
    private double longitude = BUD_LONG;

    private Repository() {
        weatherModel = new WeatherModel();
        getWeather();
        //setupRefreshTimer();
    }

    public static Repository getInstance(){
        return instance;
    }

    private void setupRefreshTimer(){
        new Timer().schedule(new TimerTask() {
            @Override public void run() {getWeather();}
        }, 0, REFRESH_TIME);
    }

    public void getWeather() {
        Log.d(TAG, "Current longitude: " + longitude);
        Log.d(TAG, "Current latitude: " + latitude);
        DarkSkyForecastEndpoint endpoint = DarkSkyWeatherClient.getRetrofitInstance().create(DarkSkyForecastEndpoint.class);
        Call<ForecastResponse> call = endpoint.getForecast(API_KEY_DARKSKY, latitude, longitude);
        call.enqueue(new Callback<ForecastResponse>() {
            @Override public void onResponse(@NonNull Call<ForecastResponse> call, @NonNull Response<ForecastResponse> response) {
                if(response.body() != null){
                    weatherModel = new WeatherModel(response.body());
                    notifyWeatherObservers();
                }
            }
            @Override public void onFailure(@NonNull Call<ForecastResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "Error");
                Log.e(TAG, t.getMessage());
            }
        });
    }

    public WeatherModel getWeatherModel(){
        return this.weatherModel;
    }

    public void getLocationPredictions(String input){
        GooglePlacesEndpoint endpoint = GooglePlacesClient.getRetrofitInstance().create(GooglePlacesEndpoint.class);
        Call<AutocompleteResponse> call = endpoint.getAutocomplete(input,"(cities)", API_KEY_GOOGLE, sessionToken);
        call.enqueue(new Callback<AutocompleteResponse>() {
            @Override public void onResponse(@NonNull Call<AutocompleteResponse> call, @NonNull Response<AutocompleteResponse> response) {
                if(response.body() != null){
                    Log.d(TAG, response.body().getStatus());
                    if(response.body().getPredictions().size() > 0) Log.d(TAG, response.body().getPredictions().get(0).getDescription());
                    locationPredictions.clear();
                    locationPredictions.addAll(response.body().getPredictions());
                    notifyPlaceObservers();
                }
            }
            @Override public void onFailure(@NonNull Call<AutocompleteResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "Error");
                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void getPlaceDetails(String placeId){
        GooglePlacesEndpoint endpoint = GooglePlacesClient.getRetrofitInstance().create(GooglePlacesEndpoint.class);
        Call<DetailsResponse> call = endpoint.getDetails(placeId, API_KEY_GOOGLE);
        call.enqueue(new Callback<DetailsResponse>() {
            @Override public void onResponse(@NonNull Call<DetailsResponse> call, @NonNull Response<DetailsResponse> response) {
                if(response.body() != null){
                    latitude = response.body().getLatitude();
                    longitude = response.body().getLongitude();
                    getWeather();
                    notifyPlaceObservers();
                }
            }
            @Override public void onFailure(@NonNull Call<DetailsResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "Error");
                Log.e(TAG, t.getMessage());
            }
        });
    }

    @Override
    public void registerWeatherObserver(WeatherObserver observer) {
        if(!weatherObservers.contains(observer)) {
            weatherObservers.add(observer);
        }
    }

    @Override
    public void removeWeatherObserver(WeatherObserver observer) {
        weatherObservers.remove(observer);
        sessionToken = null;
    }

    @Override
    public void notifyWeatherObservers() {
        for(WeatherObserver observer: weatherObservers) {
            observer.onWeatherDataChanged(weatherModel);
        }
    }

    @Override
    public void registerPlaceObserver(PlaceObserver observer) {
        if(!placeObservers.contains(observer)) {
            placeObservers.add(observer);
            createSessionToken();
        }
    }

    @Override
    public void removePlaceObserver(PlaceObserver observer) {
        placeObservers.remove(observer);
    }

    @Override
    public void notifyPlaceObservers() {
        for(PlaceObserver observer : placeObservers) {
            observer.onPredictionsChanged(locationPredictions);
        }
    }

    private void createSessionToken(){
        this.sessionToken = UUID.randomUUID().toString();
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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
