package com.valzalan.weather.api.endpoints;

import com.valzalan.weather.api.responses.darksky.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DarkSkyForecastEndpoint {
    @GET("forecast/{key}/{latitude},{longitude}")
    Call<ForecastResponse> getForecast(
            @Path("key") String key,
            @Path("latitude") double lat,
            @Path("longitude") double lon
    );
}
