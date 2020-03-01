package com.valzalan.weather.views.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.valzalan.weather.R;
import com.valzalan.weather.api.responses.google.places.Prediction;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {
    private List<Prediction> dataset;
    private SearchPresenter presenter;

    LocationAdapter(List<Prediction> dataset, SearchPresenter presenter) {
        this.dataset = dataset;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Prediction data = dataset.get(position);
        holder.cityName.setText(data.getDescription());
        holder.container.setBackgroundResource(R.drawable.details_item_bg);
        holder.container.setOnClickListener(v -> presenter.onSearchItemClick(data.getPlaceId()));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView cityName;
        View container;
        ViewHolder(View v) {
            super(v);
            cityName = v.findViewById(R.id.tvCityName);
            container = v;
        }
    }
}