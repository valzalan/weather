package com.valzalan.weather.utilities;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.valzalan.weather.R;
import com.valzalan.weather.enums.DistanceUnit;
import com.valzalan.weather.enums.PressureUnit;
import com.valzalan.weather.enums.SpeedUnit;
import com.valzalan.weather.enums.TemperatureUnit;
import com.valzalan.weather.enums.WeatherType;
import com.valzalan.weather.repository.Repository;

import static com.valzalan.weather.enums.SpeedUnit.KILOMETERS_PER_HOUR;
import static com.valzalan.weather.enums.SpeedUnit.MILES_PER_HOUR;
import static com.valzalan.weather.enums.TemperatureUnit.CELSIUS;
import static com.valzalan.weather.enums.TemperatureUnit.FAHRENHEIT;

public class Util {
    private static final String TAG = "Util";

    public static String formatTempString(int temp){
        TemperatureUnit unit = Repository.getInstance().getActiveTempUnit();
        return unit.equals(CELSIUS) ? temp + "°C" : temp + "°F";
    }

    public static String formatSpeedString(int speed){
        SpeedUnit unit = Repository.getInstance().getActiveSpeedUnit();
        return unit.equals(KILOMETERS_PER_HOUR) ? speed + " km/h" : speed + " miles/h";
    }

    public static String formatDistanceString(double distance){
        DistanceUnit unit = Repository.getInstance().getActiveDistanceUnit();
        switch (unit){
            case KILOMETERS:
                return distance + "km";
            case MILES:
                return distance + " miles";
            case FEET:
                return distance + "ft";
            case METERS:
                return distance + "m";
            default:
                Log.e(TAG, "Unknown distance unit. Returning value as string");
                return String.valueOf(distance);
        }
    }

    // The relation between mBar and hPa is 1 : 1 . No need to convert.
    public static String formatPressureString(double pressure){
        PressureUnit unit = Repository.getInstance().getActivePressureUnit();
        switch (unit) {
            case MILLIBARS:
                return pressure + " mBar";
            case HECTOPASCALS:
                return pressure + " hPa";
            default:
                Log.e(TAG, "Unknown pressure unit. No formatting performed.");
                return String.valueOf(pressure);
        }
    }

    public static int getTempInActiveUnit(int temp){
        TemperatureUnit apiTempUnit = Repository.getInstance().getAPITempUnit();
        switch (Repository.getInstance().getActiveTempUnit()){
            case CELSIUS:
                return apiTempUnit.equals(CELSIUS) ? temp : (temp - 32) * 5 / 9;
            case FAHRENHEIT:
                return apiTempUnit.equals(FAHRENHEIT) ? temp : temp * 5 / 9 + 32;
            default:
                Log.e(TAG, "Unknown temperature unit. Returning same value");
                return temp;
        }
    }

    public static int getSpeedInActiveUnit(int speed) {
        SpeedUnit apiDistanceUnit = Repository.getInstance().getAPISpeedUnit();
        switch (Repository.getInstance().getActiveSpeedUnit()){
            case KILOMETERS_PER_HOUR:
                return apiDistanceUnit.equals(KILOMETERS_PER_HOUR) ? speed : (int) (speed / 1.609);
            case MILES_PER_HOUR:
                return apiDistanceUnit.equals(MILES_PER_HOUR) ? speed : (int) (speed * 1.609);
            default:
                Log.e(TAG, "Unknown speed unit. Returning same value");
                return speed;
        }

    }

    public static Gradient getGradient(Context ctx, WeatherType weatherType){
        switch (weatherType){
            case CLEAR_DAY:
                return new Gradient(ctx, R.color.clearDayGradientStart, R.color.clearDayGradientEnd);
            case CLEAR_NIGHT:
                return new Gradient(ctx, R.color.clearNightGradientStart, R.color.clearNightGradientEnd);
            case CLOUDY:
            case PARTLY_CLOUDY_DAY:
            case PARTLY_CLOUDY_NIGHT:
            case WIND:
                return new Gradient(ctx, R.color.cloudyGradientStart, R.color.cloudyGradientEnd);
            case RAIN:
            case STORM:
                return new Gradient(ctx, R.color.stormGradientStart, R.color.stormGradientEnd);
            case FOG:
                return new Gradient(ctx, R.color.fogGradientStart, R.color.fogGradientEnd);
            case SLEET:
            case SNOW:
                return new Gradient(ctx, R.color.sleetGradientStart, R.color.sleetGradientEnd);
            case HOT:
                return new Gradient(ctx, R.color.hotGradientStart, R.color.hotGradientEnd);
            case SANDSTORM:
                return new Gradient(ctx, R.color.sandStormGradientStart, R.color.sandStormGradientEnd);
            case TORNADO:
                return new Gradient(ctx, R.color.tornadoGradientStart, R.color.tornadoGradientEnd);
            default:
                Log.e(TAG, "Unknown weather type, defaulting to clear gradient");
                return new Gradient(ctx, R.color.clearDayGradientStart, R.color.clearDayGradientEnd);
        }
    }

    public static class Gradient {
        public int start;
        public int end;

        Gradient(Context context, int start, int end) {
            this.start = ContextCompat.getColor(context, start);
            this.end = ContextCompat.getColor(context, end);
        }
    }
}
