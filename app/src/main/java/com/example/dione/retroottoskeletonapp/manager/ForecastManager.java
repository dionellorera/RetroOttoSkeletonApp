package com.example.dione.retroottoskeletonapp.manager;

import android.content.Context;
import android.util.Log;

import com.example.dione.retroottoskeletonapp.api.ForecastClient;
import com.example.dione.retroottoskeletonapp.api.interfaces.IWeather;
import com.example.dione.retroottoskeletonapp.api.models.Weather;
import com.example.dione.retroottoskeletonapp.event.GetWeatherEvent;
import com.example.dione.retroottoskeletonapp.event.SendWeatherEvent;
import com.example.dione.retroottoskeletonapp.event.SendWeatherEventError;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by dione on 11/08/2016.
 */
public class ForecastManager {
    private Context mContext;
    private Bus mBus;
    private ForecastClient sForecastClient;
    public ForecastManager(Context context, Bus bus) {
        this.mContext = context;
        this.mBus = bus;
        sForecastClient = ForecastClient.getClient();
    }
}
