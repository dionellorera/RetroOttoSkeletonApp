package com.example.dione.retroottoskeletonapp.api;

import com.example.dione.retroottoskeletonapp.api.interfaces.IWeather;
import com.example.dione.retroottoskeletonapp.api.models.Weather;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dione on 11/08/2016.
 */
public class ForecastClient {
    private static final String BASE_URL = "https://api.forecast.io/forecast/";
    private static final String API_KEY = "e672a6f926d89cd9770047901f20847f/";
    public static final String API_URL = BASE_URL + API_KEY;

    private static ForecastClient mForecastClient;
    public static Retrofit mRestAdapter;

    public static ForecastClient getClient() {
        if (mForecastClient == null)
            mForecastClient = new ForecastClient();
        return mForecastClient;
    }

    private ForecastClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        mRestAdapter = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

}
