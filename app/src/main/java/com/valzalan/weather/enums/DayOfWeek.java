package com.valzalan.weather.enums;

import android.util.Log;

public enum DayOfWeek {
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);

    private int value;

    DayOfWeek(int value){
        this.value = value;
    }

    public int asInt(){
        return value;
    }

    public String toShortString(DayOfWeek day){
        switch (day){
            case MONDAY:
                return "Mon";
            case TUESDAY:
                return "Tue";
            case WEDNESDAY:
                return "Wed";
            case THURSDAY:
                return "Thu";
            case FRIDAY:
                return "Fri";
            case SATURDAY:
                return "Sat";
            case SUNDAY:
                return "Sun";
            default:
                Log.e("DayOfWeek", "Unknown day value.");
        }
        return null;
    }
}
