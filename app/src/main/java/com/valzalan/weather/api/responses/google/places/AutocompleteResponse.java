package com.valzalan.weather.api.responses.google.places;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AutocompleteResponse {
    @SerializedName("status")
    private String status;
    @SerializedName("predictions")
    private List<Prediction> predictions;

    public AutocompleteResponse(String status, List<Prediction> predictions) {
        this.status = status;
        this.predictions = predictions;
    }

    public String getStatus() {
        return status;
    }

    public List<Prediction> getPredictions() {
        return predictions;
    }
}
