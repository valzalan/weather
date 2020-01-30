package com.valzalan.weather.api.deserializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.valzalan.weather.api.responses.Alert;
import com.valzalan.weather.api.responses.custom.CurrentWeatherData;
import com.valzalan.weather.api.responses.custom.DailyWeatherData;
import com.valzalan.weather.api.responses.custom.ForecastResponse;
import com.valzalan.weather.api.responses.custom.HourlyWeatherData;
import com.valzalan.weather.api.responses.custom.Location;
import com.valzalan.weather.api.responses.custom.MinutelyWeatherData;
import com.valzalan.weather.api.responses.custom.WeatherDataHeader;
import com.valzalan.weather.api.responses.custom.WindData;
import com.valzalan.weather.api.responses.custom.precipitation.PrecipitationData;
import com.valzalan.weather.api.responses.custom.precipitation.PrecipitationDataBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DarkSkyForecastDeserializer implements JsonDeserializer<ForecastResponse> {
    @Override
    public ForecastResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        CurrentWeatherData current = new CurrentWeatherData();
        WeatherDataHeader<MinutelyWeatherData> minutely = new WeatherDataHeader<>();
        WeatherDataHeader<HourlyWeatherData> hourly = new WeatherDataHeader<>();
        WeatherDataHeader<DailyWeatherData> daily = new WeatherDataHeader<>();

        return new ForecastResponse(
                new Location(
                        jsonObject.get("latitude").getAsDouble(),
                        jsonObject.get("longitude").getAsDouble(),
                        jsonObject.get("timezone").getAsString()
                ),
                current,
                minutely,
                hourly,
                daily,
                getAlerts(jsonObject.get("alerts").getAsJsonObject())
                );
    }

    private CurrentWeatherData getCurrent(JsonObject currentlyObj) {
        return new CurrentWeatherData(
                currentlyObj.get("time").getAsLong(),
                currentlyObj.get("summary").getAsString(),
                currentlyObj.get("icon").getAsString(),
                currentlyObj.get("nearestStormDistance").getAsDouble(),
                getPrecipitationForCurrent(currentlyObj),
                currentlyObj.get("temperature").getAsDouble(),
                currentlyObj.get("apparentTemperature").getAsDouble(),
                currentlyObj.get("dewPoint").getAsDouble(),
                currentlyObj.get("dewPoint").getAsDouble(),
                currentlyObj.get("dewPoint").getAsDouble(),
                getWindDataForCurrent(currentlyObj),


        )
    }

    private WindData getWindDataForCurrent(JsonObject currentlyObj){

    }

    private PrecipitationData getPrecipitationForCurrent(JsonObject currentlyObj){
        return new PrecipitationDataBuilder()
                .setPrecipIntensity(currentlyObj.get("precipIntensity").getAsDouble())
                .setPrecipIntensityError(currentlyObj.get("precipIntensityError").getAsDouble())
                .setPrecipProbability(currentlyObj.get("precipProbability").getAsDouble())
                .setPrecipType(currentlyObj.get("precipType").getAsString())
                .build();
    }

    private List<Alert> getAlerts(JsonObject alertsObj) {
        List<Alert> alerts = new ArrayList<>();
        JsonArray arr = alertsObj.getAsJsonArray();
        for(JsonElement element : arr){
            JsonObject item = element.getAsJsonObject();
            alerts.add(new Alert(
                    item.get("title").getAsString(),
                    item.get("time").getAsLong(),
                    item.get("expires").getAsLong(),
                    item.get("description").getAsString(),
                    item.get("uri").getAsString()
            ));
        }
        return alerts;
    }
}
