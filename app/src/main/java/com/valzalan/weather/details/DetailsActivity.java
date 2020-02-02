package com.valzalan.weather.details;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.valzalan.weather.R;
import com.valzalan.weather.components.DetailsItemView;
import com.valzalan.weather.models.ForecastModel;
import com.valzalan.weather.models.WeatherModel;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity implements DetailsView {
    private DetailsPresenter presenter;
    private LineChart chart;
    private RecyclerView forecast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        chart = findViewById(R.id.chart);
        initForecastView();
        presenter = new BasicDetailsPresenter(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.viewPaused();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.viewResumed();
    }

    private void initForecastView(){
        forecast = findViewById(R.id.rvForecast);
        forecast.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        );
    }

    @Override
    public void update(WeatherModel model) {
        updateChart(model.getPrecipitationForecast());
        updateForecast(model.getNextSevenDaysForecast());
        ((DetailsItemView) findViewById(R.id.diFeelsLike))
                .setValue(String.valueOf(model.getApparentTemp()));
        ((DetailsItemView) findViewById(R.id.diHumidity))
                .setValue(String.valueOf(model.getHumidity()));
        ((DetailsItemView) findViewById(R.id.diPressure))
                .setValue(String.valueOf(model.getPressure()));
        ((DetailsItemView) findViewById(R.id.diDewPoint))
                .setValue(String.valueOf(model.getDewPoint()));
        ((DetailsItemView) findViewById(R.id.diVisibility))
                .setValue(String.valueOf(model.getVisibility()));
        ((DetailsItemView) findViewById(R.id.diWind))
                .setValue(String.valueOf(model.getWindSpeed()));
    }

    private void updateForecast(List<ForecastModel> dataList){
        ForecastAdapter adapter = new ForecastAdapter(dataList);
        forecast.setAdapter(adapter);
    }

    private void updateChart(int[] precipForecast){
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < precipForecast.length; i++) {
            entries.add(new Entry(i, precipForecast[i]));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Temperature");
        dataSet.setColor(R.color.accent);
        dataSet.setValueTextColor(R.color.accent);
        chart.setData(new LineData(dataSet));
        chart.invalidate();
    }
}
