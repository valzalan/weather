package com.valzalan.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.valzalan.weather.details.DetailsActivity;
import com.valzalan.weather.models.WeatherModel;
import com.valzalan.weather.search.SearchActivity;

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
        presenter.viewResumed();
    }

    @Override
    public void update(WeatherModel model) {
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

    private void updateChart(int[] tempForecast){
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < tempForecast.length; i++) {
            entries.add(new Entry(i, tempForecast[i]));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Temperature");
        dataSet.setColor(R.color.accent);
        dataSet.setValueTextColor(R.color.accent);
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
