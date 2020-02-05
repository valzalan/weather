package com.valzalan.weather.api.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GooglePlacesClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
