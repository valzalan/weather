package com.valzalan.weather.api.responses.custom.precipitation;

public class PrecipitationDataBuilder {
    private double precipIntensity;
    private double precipIntensityError;
    private double precipProbability;
    private String precipType;
    private double precipIntensityMax;
    private long precipIntensityMaxTime;

    public PrecipitationDataBuilder(){}

    public PrecipitationDataBuilder setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
        return this;
    }

    public PrecipitationDataBuilder setPrecipIntensityError(double precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
        return this;
    }

    public PrecipitationDataBuilder setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
        return this;
    }

    public PrecipitationDataBuilder setPrecipType(String precipType) {
        this.precipType = precipType;
        return this;
    }

    public PrecipitationDataBuilder setPrecipIntensityMax(double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
        return this;
    }

    public PrecipitationDataBuilder setPrecipIntensityMaxTime(long precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
        return this;
    }

    public PrecipitationData build(){
        PrecipitationData res = new PrecipitationData();
        res.setPrecipIntensity(this.precipIntensity);
        res.setPrecipIntensityError(this.precipIntensityError);
        res.setPrecipIntensityMax(this.precipIntensityMax);
        res.setPrecipIntensityMaxTime(this.precipIntensityMaxTime);
        res.setPrecipProbability(this.precipProbability);
        res.setPrecipType(this.precipType);
        return res;
    }
}