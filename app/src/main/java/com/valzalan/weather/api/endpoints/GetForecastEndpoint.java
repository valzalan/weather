package com.valzalan.weather.api.endpoints;

import com.valzalan.weather.api.responses.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetForecastEndpoint {
    @GET("forecast/{key}/{latitude},{longitude}")
    Call<ForecastResponse> getForecast(@Path("key") String key, @Path("latitude") double latitude, @Path("longitude") double longitude);
}
