package com.valzalan.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.valzalan.weather.api.endpoints.GetForecastEndpoint;
import com.valzalan.weather.api.network.RetrofitClient;
import com.valzalan.weather.api.responses.ForecastResponse;
import com.valzalan.weather.details.DetailsActivity;
import com.valzalan.weather.search.SearchActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainView {
    private static final String TAG = "MainActivity";
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new BasicMainPresenter(this);
        findViewById(R.id.button).setOnClickListener(v -> startDetailsView());
        findViewById(R.id.ibAdd).setOnClickListener(v -> startSearchView());
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
