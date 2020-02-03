package com.valzalan.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.valzalan.weather.enums.WeatherType;
import com.valzalan.weather.models.WeatherModel;
import com.valzalan.weather.utilities.Util;
import com.valzalan.weather.views.details.DetailsActivity;
import com.valzalan.weather.views.search.SearchActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter presenter;
    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart = findViewById(R.id.chart);
        setupChart();
        findViewById(R.id.button).setOnClickListener(v -> startDetailsView());
        findViewById(R.id.ibAdd).setOnClickListener(v -> startSearchView());
        presenter = new BasicMainPresenter(this);
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

    @Override
    public void update(WeatherModel model) {
        setBackgroundGradient(model.getWeatherType());
        updateChart(model.getTempNextSixHours());
        ((TextView) findViewById(R.id.tvLocationName))
                .setText(model.getLocationName());
        ((TextView) findViewById(R.id.tvWeather))
                .setText(model.getSummary());
        ((TextView) findViewById(R.id.tvTempCurrent))
                .setText(String.valueOf(model.getTemp()));
        ((TextView) findViewById(R.id.tvTempMax))
                .setText(String.valueOf(model.getTempMax()));
        ((TextView) findViewById(R.id.tvTempMin))
                .setText(String.valueOf(model.getTempMin()));
    }

    private void setBackgroundGradient(WeatherType weatherType) {
        Util.Gradient gradient = Util.getGradient(this, weatherType);

        GradientDrawable drawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {gradient.start, gradient.end}
                );

        findViewById(R.id.mainContainer).setBackground(drawable);
    }

    private void setupChart(){
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisLeft().setDrawLabels(false);
        chart.setDrawGridBackground(false);
        chart.setDrawBorders(false);
        chart.setDrawMarkers(false);
        chart.setTouchEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.getDescription().setEnabled(false);

        XAxis xAxis = chart.getXAxis();
        YAxis yAxis = chart.getAxisLeft();
        //yAxis.setAxisMaximum(20f);
        //yAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis.setDrawAxisLine(false);
        xAxis.setTextSize(15f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setGridLineWidth(1f);
        xAxis.setGridColor(Color.WHITE);
        xAxis.setValueFormatter(getXAxisValueFormatter());
    }

    private ValueFormatter getXAxisValueFormatter(){
        final String[] quarters = new String[] { "NOW", "2pm", "3pm", "4pm", "5pm", "6pm" };
        return new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return quarters[(int) value];
            }
        };
    }

    private void updateChart(int[] tempForecast){
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < tempForecast.length; i++) {
            entries.add(new Entry(i, tempForecast[i]));
        }
        LineDataSet dataSet = new LineDataSet(entries, "");
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet.setColor(Color.WHITE);
        dataSet.setValueTextSize(13f);
        dataSet.setValueTextColor(Color.WHITE);
        chart.setData(new LineData(dataSet));
        chart.invalidate();
    }

    @Override
    public void startSearchView(){
        startActivity(new Intent(this, SearchActivity.class));
    }

    @Override
    public void startDetailsView(){
        startActivity(new Intent(this, DetailsActivity.class));
    }
}
