package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

public class Alert {
    @SerializedName("title")
    private String title;
    @SerializedName("time")
    private double time;
    @SerializedName("description")
    private String description;
    @SerializedName("uri")
    private String uri;

    public Alert(String title, double time, String description, String uri) {
        this.title = title;
        this.time = time;
        this.description = description;
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
