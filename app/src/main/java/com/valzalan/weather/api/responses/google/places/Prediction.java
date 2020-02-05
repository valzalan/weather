package com.valzalan.weather.api.responses.google.places;

import com.google.gson.annotations.SerializedName;

public class Prediction {
    @SerializedName("description")
    private String description;
    @SerializedName("place_id")
    private String placeId;

    public Prediction(String description, String placeId) {
        this.description = description;
        this.placeId = placeId;
    }

    public String getDescription() {
        return description;
    }

    public String getPlaceId() {
        return placeId;
    }
}
