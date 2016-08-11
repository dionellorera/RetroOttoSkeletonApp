package com.example.dione.retroottoskeletonapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.dione.retroottoskeletonapp.api.models.Currently;
import com.example.dione.retroottoskeletonapp.api.models.Weather;
import com.example.dione.retroottoskeletonapp.application.ForecastApplication;
import com.example.dione.retroottoskeletonapp.event.GetWeatherEvent;
import com.example.dione.retroottoskeletonapp.event.SendWeatherEvent;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {
    ForecastApplication forecastApplication;
    TextView forecastTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        sendWeatherRequest();
    }

    private void initialize(){
        forecastTextView = (TextView) findViewById(R.id.forecastTextView);
    }

    private void sendWeatherRequest(){
        forecastApplication = new ForecastApplication();
        forecastApplication.mBus.post(new GetWeatherEvent(14.599512, 120.984222));
        forecastTextView.setText("Waiting for API Response");
    }

    @Subscribe
    public void onSendWeatherEvent(SendWeatherEvent sendWeatherEvent) {
        Weather weather = sendWeatherEvent.getWeather();
        Currently currently = weather.getCurrently();
        forecastTextView.setText(currently.getSummary());
    }

    @Override
    public void onResume() {
        super.onResume();
        forecastApplication.mBus.register(this);
    }
    @Override
    public void onPause() {
        super.onPause();
        forecastApplication.mBus.unregister(this);
    }
}
