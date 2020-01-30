package com.valzalan.weather.enums;

import android.util.Log;

//TODO: Separate ?
public enum WeatherType {
    CLEAR_DAY,
    CLEAR_NIGHT,
    PARTLY_CLOUDY_DAY,
    PARTLY_CLOUDY_NIGHT,
    RAIN,
    SNOW,
    WIND,
    HOT,
    STORM,
    CLOUDY,
    FOG,
    SLEET,
    SANDSTORM,
    TORNADO;

    public static WeatherType fromValue(String value){
        switch (value){
            case "clear-day":
                return CLEAR_DAY;
            case "clear-night":
                return CLEAR_NIGHT;
            case "rain":
                return RAIN;
            case "snow":
                return SNOW;
            case "sleet":
                return SLEET;
            case "wind":
                return WIND;
            case "fog":
                return FOG;
            case "cloudy":
                return CLOUDY;
            case "partly-cloudy-day":
                return PARTLY_CLOUDY_DAY;
            case "partly-cloudy-night":
                return PARTLY_CLOUDY_NIGHT;
            default:
                Log.e("WeatherType", "Unknown WeatherType value. Defaulting to CLEAR_DAY");
                return CLEAR_DAY;
        }
    }
}
