package com.valzalan.weather.views.details;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.valzalan.weather.R;

public class DetailsActivity extends AppCompatActivity implements DetailsView {
    private DetailsPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        presenter = new BasicDetailsPresenter(this);
    }
}
