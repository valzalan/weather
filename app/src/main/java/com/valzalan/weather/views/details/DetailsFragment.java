package com.valzalan.weather.views.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import com.valzalan.weather.utilities.Util;

import java.util.ArrayList;
import java.util.List;

public class DetailsFragment extends Fragment implements DetailsView {
    private DetailsPresenter presenter;
    private LineChart chart;
    private RecyclerView forecast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        chart = v.findViewById(R.id.chart);
        setupChart();
        forecast = v.findViewById(R.id.rvForecast);
        forecast.setLayoutManager(
                new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false)
        );
        presenter = new BasicDetailsPresenter(this);
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

    @Override
    public void update(WeatherModel model) {
        View v = getView();
        updateChart(model.getPrecipitationForecast());
        updateForecast(model.getNextSevenDaysForecast());
        ((DetailsItemView) v.findViewById(R.id.diFeelsLike))
                .setValue(model.getApparentTemp() + "°");
        ((DetailsItemView) v.findViewById(R.id.diHumidity))
                .setValue(model.getHumidity() + "%");
        ((DetailsItemView) v.findViewById(R.id.diPressure))
                .setValue(Util.formatPressureString(model.getPressure()));
        ((DetailsItemView) v.findViewById(R.id.diDewPoint))
                .setValue(model.getDewPoint() + "°");
        ((DetailsItemView) v.findViewById(R.id.diVisibility))
                .setValue(Util.formatDistanceString(model.getVisibility()));
        ((DetailsItemView) v.findViewById(R.id.diWind))
                .setValue(Util.formatSpeedString(model.getWindSpeed()));
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
