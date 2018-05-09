package com.example.dione.retroottoskeletonapp.manager;

import android.util.Log;

import com.example.dione.retroottoskeletonapp.application.ForecastApplication;
import com.example.dione.retroottoskeletonapp.bus.BusProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseService {
    public BaseService(ForecastApplication minutesApplication){
        BusProvider.getInstance().register(this);
    }
    protected <T> void asyncRequest(Call<T> apiCall) {
        apiCall.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                BusProvider.getInstance().post(response.body());
                }

            @Override
            public void onFailure(Call<T> call, Throwable t) {

            }
        });

    }
}
