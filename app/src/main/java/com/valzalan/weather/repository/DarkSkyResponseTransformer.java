package com.valzalan.weather.repository;

import com.valzalan.weather.api.responses.CurrentWeatherData;
import com.valzalan.weather.api.responses.DailyWeather;
import com.valzalan.weather.api.responses.DailyWeatherData;
import com.valzalan.weather.api.responses.ForecastResponse;
import com.valzalan.weather.api.responses.HourlyWeatherData;
import com.valzalan.weather.enums.DayOfWeek;
import com.valzalan.weather.enums.WeatherType;
import com.valzalan.weather.models.ForecastModel;
import com.valzalan.weather.models.LocationModel;

import java.util.ArrayList;
import java.util.List;

public class DarkSkyResponseTransformer implements ResponseTransformer {

    @Override
    public LocationModel createLocationModel(ForecastResponse response){
        CurrentWeatherData current = response.getCurrentWeather();
        DailyWeather daily = response.getDailyWeather();

        LocationModel model = new LocationModel(response.getTimezone());
        model.setWeatherType(WeatherType.fromValue(current.getIcon()));
        model.setTemp((int) current.getTemperature());
        model.setTempMax((int) daily.getData().get(0).getTemperatureMax());
        model.setTempMin((int) daily.getData().get(0).getTemperatureMin());
        model.setTempNextSixHours(createTemperatureForecast(response.getHourlyWeatherData().getData()));
        model.setApparentTemp((int) current.getApparentTemperature());
        model.setWindSpeed((int) current.getWindSpeed());
        model.setHumidity((int) current.getHumidity() * 100);
        model.setPressure(current.getPressure());
        model.setVisibility(current.getVisibility());
        model.setDewPoint((int) current.getDewPoint() * 100);
        model.setPrecipicationForecast(createPrecipitationForecast(response.getHourlyWeatherData().getData()));
        model.setNextSevenDaysForecast(createForecastModelList(response));

        return model;
    }

    private List<Integer> createPrecipitationForecast(List<HourlyWeatherData> list){
        List<Integer> result = new ArrayList<>();
        for(HourlyWeatherData data : list) result.add((int) data.getPrecipProbability() * 100);
        return result;
    }

    private List<Integer> createTemperatureForecast(List<HourlyWeatherData> list){
        List<Integer> result = new ArrayList<>();
        for(HourlyWeatherData data : list) result.add((int) data.getTemperature());
        return result;
    }

    @Override
    public List<ForecastModel> createForecastModelList(ForecastResponse response){
        List<DailyWeatherData> list = response.getDailyWeather().getData();
        List<ForecastModel> result = new ArrayList<>();
        for(DailyWeatherData data : list) result.add(createForecastModel(data));
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
}
