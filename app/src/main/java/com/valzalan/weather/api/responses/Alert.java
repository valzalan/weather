package com.valzalan.weather.api.responses;

import com.google.gson.annotations.SerializedName;

public class Alert {
    @SerializedName("title")
    private String title;
    @SerializedName("time")
    private double time;
    @SerializedName("expires")
    private double expires;
    @SerializedName("description")
    private String description;
    @SerializedName("uri")
    private String uri;

    public Alert(String title, double time, double expires, String description, String uri) {
        this.title = title;
        this.time = time;
        this.expires = expires;
        this.description = description;
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public double getTime() {
        return time;
    }

    public double getExpires() {
        return expires;
    }

    public String getDescription() {
        return description;
    }

    public String getUri() {
        return uri;
    }
}
