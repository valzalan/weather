package com.valzalan.weather.views.search;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.valzalan.weather.R;
import com.valzalan.weather.api.responses.google.places.Prediction;
import com.valzalan.weather.enums.WeatherType;
import com.valzalan.weather.repository.Repository;
import com.valzalan.weather.utilities.Util;
import com.valzalan.weather.views.details.ForecastAdapter;

import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class SearchActivity extends AppCompatActivity implements SearchView {
    private static final String TAG = "SearchActivity";
    private SearchPresenter presenter;
    private RecyclerView locationList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        presenter = new BasicSearchPresenter(this);
        setBackgroundGradient(Repository.getInstance().getWeatherModel().getWeatherType());
        locationList = findViewById(R.id.rvLocationList);
        locationList.setLayoutManager(
                new LinearLayoutManager(this, VERTICAL, false)
        );
        setTextWatcher();
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

    private void setTextWatcher() {
        EditText input = findViewById(R.id.etLocationInput);
        input.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG, "Location input changed");
                if(charSequence.length() != 0) presenter.onInputChanged(charSequence.toString());
            }
            @Override public void afterTextChanged(Editable editable){}
        });
    }

    private void setBackgroundGradient(WeatherType weatherType) {
        Util.Gradient gradient = Util.getGradientForWeatherType(this, weatherType);

        GradientDrawable drawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {gradient.start, gradient.end}
        );

        findViewById(R.id.mainContainer).setBackground(drawable);
    }

    @Override
    public void updateList(List<Prediction> list) {
        LocationAdapter adapter = new LocationAdapter(list);
        locationList.setAdapter(adapter);
    }
}
