package com.valzalan.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new BasicMainPresenter(this);
        findViewById(R.id.button).setOnClickListener(v ->
            startActivity(new Intent(this, com.valzalan.weather.details.DetailsActivity.class))
        );
    }
}
