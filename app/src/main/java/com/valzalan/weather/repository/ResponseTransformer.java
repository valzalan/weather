package com.valzalan.weather.repository;

import com.valzalan.weather.api.responses.ForecastResponse;
import com.valzalan.weather.models.ForecastModel;
import com.valzalan.weather.models.LocationModel;

import java.util.List;

public interface ResponseTransformer {
    LocationModel createLocationModel(ForecastResponse response);
    List<ForecastModel> createForecastModelList(ForecastResponse response);
}
