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

    private final String API_KEY = "48f93f8337d0b5b9dcb351c452a7fc38";
    private final double BUD_LAT = 47.4979;
    private final double BUD_LONG = 19.0402;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new BasicMainPresenter(this);
        findViewById(R.id.button).setOnClickListener(v -> startDetailsView());
        findViewById(R.id.ibAdd).setOnClickListener(v -> startSearchView());

        GetForecastEndpoint endpoint = RetrofitClient.getRetrofitInstance().create(GetForecastEndpoint.class);
        Call<ForecastResponse> call = endpoint.getForecast(API_KEY, BUD_LAT, BUD_LONG);
        Log.d(TAG, "ENQUEUEING!!!!!!!!!!!!");
        call.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                Log.d(TAG, "SUCCESS!!!!!!!!!!");
                Log.d(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                Log.e(TAG, "ERROR!!!!!!!!!!!!");
                Log.e(TAG, t.getMessage());
            }
        });

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
