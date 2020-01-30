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

    private LocationModel createLocationModel(ForecastResponse response){
        CurrentWeatherData current = response.getCurrentWeather();
        DailyWeather daily = response.getDailyWeather();

        LocationModel model = new LocationModel(response.getTimezone());
        model.setWeatherType(WeatherType.fromValue(current.getIcon()));
        model.setTemp((int) current.getTemperature());
        model.setTempMax((int) daily.getData().get(0).getTemperatureMax());
        model.setTempMin((int) daily.getData().get(0).getTemperatureMin());
        model.setTempNextSixHours(createTemperatureForecast(response.getHourlyWeatherData().getData()));
        model.setApparentTemp((int) current.getApparentTemperature());
        model.setWindSpeed((int) current.getWindSpeed());
        model.setHumidity((int) current.getHumidity() * 100);
        model.setPressure(current.getPressure());
        model.setVisibility(current.getVisibility());
        model.setDewPoint((int) current.getDewPoint() * 100);
        model.setPrecipicationForecast(createPrecipitationForecast(response.getHourlyWeatherData().getData()));
        model.setNextSevenDaysForecast(createForecastModelList(daily.getData()));
        
        return model;
    }

    private List<Integer> createPrecipitationForecast(List<HourlyWeatherData> list){
        List<Integer> result = new ArrayList<>();
        for(HourlyWeatherData data : list) result.add((int) data.getPrecipProbability() * 100);
        return result;
    }

    private List<Integer> createTemperatureForecast(List<HourlyWeatherData> list){
        List<Integer> result = new ArrayList<>();
        for(HourlyWeatherData data : list) result.add((int) data.getTemperature());
        return result;
    }

    private List<ForecastModel> createForecastModelList(List<DailyWeatherData> list){
        List<ForecastModel> result = new ArrayList<>();
        for(DailyWeatherData data : list) result.add(createForecastModel(data));
        return result;
    }

    private ForecastModel createForecastModel(DailyWeatherData data){
        return new ForecastModel(
                DayOfWeek.MONDAY,
                (int) data.getPrecipProbability() * 100,
                WeatherType.fromValue(data.getIcon()),
                (int) data.getTemperatureMax(),
                (int) data.getTemperatureMin()
        );
    }

    public Repository getInstance(){
        return instance;
    }
}
