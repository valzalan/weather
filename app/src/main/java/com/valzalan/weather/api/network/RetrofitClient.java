package com.valzalan.weather.api.network;

import com.google.gson.GsonBuilder;
import com.valzalan.weather.api.deserializers.DarkSkyForecastDeserializer;
import com.valzalan.weather.api.responses.custom.ForecastResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.darksky.net/";

    public static Retrofit getRetrofitInstance() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ForecastResponse.class, new DarkSkyForecastDeserializer());

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                    .build();
        }
        return retrofit;
    }


}
