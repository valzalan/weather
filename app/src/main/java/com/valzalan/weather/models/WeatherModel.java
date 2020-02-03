package com.valzalan.weather.models;

import com.valzalan.weather.api.responses.CurrentWeatherData;
import com.valzalan.weather.api.responses.DailyWeather;
import com.valzalan.weather.api.responses.DailyWeatherData;
import com.valzalan.weather.api.responses.ForecastResponse;
import com.valzalan.weather.api.responses.HourlyWeatherData;
import com.valzalan.weather.enums.DayOfWeek;
import com.valzalan.weather.enums.WeatherType;

import java.util.ArrayList;
import java.util.List;

public class WeatherModel {
    private String locationName = "";
    private String summary = "";
    private WeatherType weatherType = WeatherType.CLEAR_DAY;
    private int temp = 0;
    private int tempMax = 0;
    private int tempMin = 0;
    private int[] tempNextSixHours = new int[6];
    private int apparentTemp = 0;
    private int windSpeed = 0;
    private int humidity = 0;
    private double pressure = 0;
    private double visibility = 0;
    private int dewPoint = 0;
    private int[] precipitationForecast = new int[6];
    private List<ForecastModel> nextSevenDaysForecast = new ArrayList<>();

    public WeatherModel(){}

    public WeatherModel(ForecastResponse response){
        CurrentWeatherData current = response.getCurrentWeather();
        DailyWeather daily = response.getDailyWeather();

        String zone = response.getTimezone();
        this.locationName = zone.substring(zone.indexOf('/') + 1).replace('_', ' ');
        this.summary = current.getSummary();
        this.weatherType = WeatherType.fromValue(current.getIcon());
        this.temp = (int) current.getTemperature();
        this.tempMax = (int) daily.getData().get(0).getTemperatureMax();
        this.tempMin = (int) daily.getData().get(0).getTemperatureMin();
        this.tempNextSixHours = createTemperatureForecast(response.getHourlyWeatherData().getData());
        this.apparentTemp = (int) current.getApparentTemperature();
        this.windSpeed = (int) current.getWindSpeed();
        this.humidity = (int) current.getHumidity() * 100;
        this.pressure = current.getPressure();
        this.visibility = current.getVisibility();
        this.dewPoint = (int) current.getDewPoint() * 100;
        this.precipitationForecast = createPrecipitationForecast(response.getHourlyWeatherData().getData());
        this.nextSevenDaysForecast = createForecastModelList(daily.getData());
    }

    private int[] createPrecipitationForecast(List<HourlyWeatherData> list){
        int[] result = new int[6];
        for(int i = 0; i < result.length; i++){
            result[i] = (int) (list.get(i).getPrecipProbability() * 100);
        }
        return result;
    }

    private int[] createTemperatureForecast(List<HourlyWeatherData> list){
        int[] result = new int[6];
        for(int i = 0; i < result.length; i++){
            result[i] = (int) list.get(i).getTemperature();
        }
        return result;
    }

    private List<ForecastModel> createForecastModelList(List<DailyWeatherData> list){
        List<ForecastModel> result = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            result.add(createForecastModel(list.get(i)));
        }
        return result;
    }

    private ForecastModel createForecastModel(DailyWeatherData data){
        return new ForecastModel(
                DayOfWeek.MONDAY,
                (int) data.getPrecipProbability() * 100,
                WeatherType.fromValue(data.getIcon()),
                (int) data.getTemperatureMax(),
                (int) data.getTemperatureMin()
        );
    }

    public String getLocationName() {
        return locationName;
    }

    public String getSummary() {
        return summary;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public int getTemp() {
        return temp;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public int[] getTempNextSixHours() {
        return tempNextSixHours;
    }

    public int getApparentTemp() {
        return apparentTemp;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getVisibility() {
        return visibility;
    }

    public int getDewPoint() {
        return dewPoint;
    }

    public int[] getPrecipitationForecast() {
        return precipitationForecast;
    }

    public List<ForecastModel> getNextSevenDaysForecast() {
        return nextSevenDaysForecast;
    }
}
