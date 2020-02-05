package com.valzalan.weather;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.valzalan.weather.enums.WeatherType;
import com.valzalan.weather.models.WeatherModel;
import com.valzalan.weather.repository.Repository;
import com.valzalan.weather.repository.RepositoryObserver;
import com.valzalan.weather.utilities.Util;
import com.valzalan.weather.views.details.DetailsFragment;
import com.valzalan.weather.views.main.MainFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RepositoryObserver {
    private static final String TAG = "MainActivity";
    private TextView dateAndTime;
    private final Handler dateHandler = new Handler();
    private final Runnable dateRunnable = this::setCurrentDateAndTimeText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
        setupPager();

        dateAndTime = findViewById(R.id.tvDateAndTime);
        setupDateTimer();

        findViewById(R.id.ibMenu).setOnClickListener(v -> openDrawer());
        findViewById(R.id.ibAdd).setOnClickListener(v -> startSearchView());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Repository.getInstance().registerObserver(this);
        hideSystemUI();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Repository.getInstance().removeObserver(this);
    }

    private void openDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.openDrawer(GravityCompat.START);
    }

    private void setupPager(){
        ViewPager pager = findViewById(R.id.pager);
        WeatherPagerAdapter pagerAdapter = new WeatherPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
    }

    private void setupDateTimer(){
        new Timer().schedule(new TimerTask() {
            @Override public void run() {dateHandler.post(dateRunnable);}
        }, 0, 1000);
    }

    private void setCurrentDateAndTimeText() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, h:mm a", Locale.getDefault());
        String dateAndTimeString = formatter.format(new Date());
        dateAndTime.setText(dateAndTimeString);
    }

    private void startSearchView() {

    }

    private void setBackgroundGradient(WeatherType weatherType) {
        Util.Gradient gradient = Util.getGradient(this, weatherType);

        GradientDrawable drawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {gradient.start, gradient.end}
        );

        findViewById(R.id.drawer_layout).setBackground(drawable);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.notifications:
                Log.d(TAG, "Notifications menu clicked!");
                return true;
            case R.id.settings:
                Log.d(TAG, "Settings menu clicked!");
                return true;
            case R.id.about:
                Log.d(TAG, "About menu clicked!");
                return true;
            default:
                Log.e(TAG, "Unrecognized menu item id. No action taken.");
                return true;
        }
    }

    @Override
    public void onWeatherDataChanged(WeatherModel model) {
        setBackgroundGradient(model.getWeatherType());
        ((TextView) findViewById(R.id.tvLocationName)).setText(model.getLocationName());
    }

    public void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    private class WeatherPagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragmentList = new ArrayList<>();

        WeatherPagerAdapter(FragmentManager fm) {
            super(fm);
            fragmentList.add(new MainFragment());
            fragmentList.add(new DetailsFragment());
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
