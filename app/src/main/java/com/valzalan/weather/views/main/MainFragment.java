package com.valzalan.weather.views.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.valzalan.weather.R;
import com.valzalan.weather.enums.WeatherType;
import com.valzalan.weather.models.WeatherModel;
import com.valzalan.weather.utilities.Util;
import com.valzalan.weather.views.search.SearchActivity;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements MainView {
    private MainPresenter presenter;
    private LineChart chart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        chart = v.findViewById(R.id.chart);
        setupChart();
        presenter = new BasicMainPresenter(this);
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.viewPaused();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.viewResumed();
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void update(WeatherModel model) {
        View v = getView();
        updateChart(model.getTempNextSixHours());
        setIcon(model.getWeatherType());
        TextView summary = v.findViewById(R.id.tvWeather);
        summary.setText(model.getSummary());
        summary.setSelected(true);
        ((TextView) v.findViewById(R.id.tvTempCurrent))
                .setText(model.getTemp() + "°");
        ((TextView) v.findViewById(R.id.tvTempMax))
                .setText(Util.formatTempString(model.getTempMax()));
        ((TextView) v.findViewById(R.id.tvTempMin))
                .setText(Util.formatTempString(model.getTempMin()));
    }

    private void setIcon(WeatherType weatherType){
        @SuppressWarnings("ConstantConditions")
        ImageView icon = getView().findViewById(R.id.ivWeather);
        icon.setImageResource(Util.getIconResForWeatherType(weatherType));
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
        final String[] hours = new String[] { "NOW", "2pm", "3pm", "4pm", "5pm", "6pm" };
        return new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return hours[(int) value];
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
        startActivity(new Intent(getContext(), SearchActivity.class));
    }
}
