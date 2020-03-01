package com.valzalan.weather.api.endpoints;

import com.valzalan.weather.api.responses.google.places.AutocompleteResponse;
import com.valzalan.weather.api.responses.google.places.DetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GooglePlacesEndpoint {
    @GET("autocomplete/json")
    Call<AutocompleteResponse> getAutocomplete(
            @Query("input") String input,
            @Query("types") String types,
            @Query("key") String key,
            @Query("sessiontoken") String sessionToken
    );

    @GET("details/json")
    Call<DetailsResponse> getDetails(
            @Query("place_id") String placeId,
            @Query("key") String key
    );
}
