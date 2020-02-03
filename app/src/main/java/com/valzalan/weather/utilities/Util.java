package com.valzalan.weather.utilities;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.valzalan.weather.R;
import com.valzalan.weather.enums.TemperatureUnit;
import com.valzalan.weather.enums.WeatherType;
import com.valzalan.weather.repository.Repository;

public class Util {
    private static final String TAG = "Util";

    public static int getTempInActiveUnit(int temp){
        TemperatureUnit apiTempUnit = Repository.getInstance().getAPITempUnit();
        switch (Repository.getInstance().getActiveTempUnit()){
            case CELSIUS:
                if(apiTempUnit.equals(TemperatureUnit.CELSIUS)) {
                    return temp;
                } else if(apiTempUnit.equals(TemperatureUnit.FAHRENHEIT)) {
                    return (temp - 32) * 5 / 9;
                }
            case FAHRENHEIT:
                if(apiTempUnit.equals(TemperatureUnit.FAHRENHEIT)){
                    return temp;
                } else if(apiTempUnit.equals(TemperatureUnit.CELSIUS)){
                    return temp * 5 / 9 + 32;
                }
            default:
                Log.e(TAG, "Unknown temperature unit. Returning same value");
                return temp;
        }
    }

    public static void hideSystemUI(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
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
