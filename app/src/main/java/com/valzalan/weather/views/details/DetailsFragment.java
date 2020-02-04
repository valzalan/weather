package com.valzalan.weather.views.details;

import android.graphics.drawable.GradientDrawable;
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
import com.valzalan.weather.enums.WeatherType;
import com.valzalan.weather.models.ForecastModel;
import com.valzalan.weather.models.WeatherModel;
import com.valzalan.weather.utilities.Util;

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
        setupChart();
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
        Util.hideSystemUI(this);
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
        setBackgroundGradient(model.getWeatherType());
        updateChart(model.getPrecipitationForecast());
        updateForecast(model.getNextSevenDaysForecast());
        ((DetailsItemView) findViewById(R.id.diFeelsLike))
                .setValue(model.getApparentTemp() + "°");
        ((DetailsItemView) findViewById(R.id.diHumidity))
                .setValue(model.getHumidity() + "%");
        ((DetailsItemView) findViewById(R.id.diPressure))
                .setValue(Util.formatPressureString(model.getPressure()));
        ((DetailsItemView) findViewById(R.id.diDewPoint))
                .setValue(model.getDewPoint() + "°");
        ((DetailsItemView) findViewById(R.id.diVisibility))
                .setValue(Util.formatDistanceString(model.getVisibility()));
        ((DetailsItemView) findViewById(R.id.diWind))
                .setValue(Util.formatSpeedString(model.getWindSpeed()));
    }

    private void setBackgroundGradient(WeatherType weatherType) {
        Util.Gradient gradient = Util.getGradient(this, weatherType);

        GradientDrawable drawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {gradient.start, gradient.end}
        );

        findViewById(R.id.mainContainer).setBackground(drawable);
    }

    private void updateForecast(List<ForecastModel> dataList){
        ForecastAdapter adapter = new ForecastAdapter(dataList);
        forecast.setAdapter(adapter);
    }

    private void setupChart(){
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisRight().setDrawLabels(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisLeft().setDrawLabels(false);
        chart.setDrawGridBackground(false);
        chart.setDrawBorders(false);
        chart.setDrawMarkers(false);
        chart.setTouchEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.getDescription().setEnabled(false);
    }

    private void updateChart(int[] precipForecast){
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < precipForecast.length; i++) {
            entries.add(new Entry(i, precipForecast[i]));
        }
        LineDataSet dataSet = new LineDataSet(entries, "");
        dataSet.setColor(R.color.primaryText);
        dataSet.setValueTextColor(R.color.primaryText);
        chart.setData(new LineData(dataSet));
        chart.invalidate();
    }
}
