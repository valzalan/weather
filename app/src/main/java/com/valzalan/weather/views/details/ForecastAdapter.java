package com.valzalan.weather.views.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.valzalan.weather.R;
import com.valzalan.weather.enums.DayOfWeek;
import com.valzalan.weather.models.ForecastModel;
import com.valzalan.weather.utilities.Util;

import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private List<ForecastModel> dataset;

    ForecastAdapter(List<ForecastModel> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ForecastAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ForecastModel model = dataset.get(position);
        String day = DayOfWeek.fromValue(position <= 6 ? position : position % 6).toShortString();
        holder.day.setText(day);
        holder.icon.setImageResource(Util.getIconResForWeatherType(model.getWeatherType()));
        int precip = model.getPrecipitation();
        holder.precipitation.setText(precip > 0 ? precip + " %" : "");
        holder.tempMax.setText(model.getTempMax() + " °C");
        holder.tempMin.setText(model.getTempMin() + " °C");
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView day, precipitation, tempMax, tempMin;
        ImageView icon;

        ViewHolder(View v) {
            super(v);
            day = v.findViewById(R.id.tvDay);
            precipitation = v.findViewById(R.id.tvPrecip);
            tempMax = v.findViewById(R.id.tvTempMax);
            tempMin = v.findViewById(R.id.tvTempMin);
            icon = v.findViewById(R.id.ivIcon);
        }
    }
}