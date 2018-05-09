package com.example.dione.retroottoskeletonapp.manager;

import com.example.dione.retroottoskeletonapp.api.ForecastClient;
import com.example.dione.retroottoskeletonapp.api.interfaces.IWeather;
import com.example.dione.retroottoskeletonapp.api.models.Weather;
import com.example.dione.retroottoskeletonapp.application.ForecastApplication;
import com.example.dione.retroottoskeletonapp.event.GetWeatherEvent;
import com.squareup.otto.Subscribe;

import retrofit2.Call;

public class UserServices  extends BaseService{
    public UserServices(ForecastApplication minutesApplication) {
        super(minutesApplication);
    }

    @Subscribe
    public void onGetWeatherEvent(GetWeatherEvent getWeatherEvent) {
        IWeather iWeather = ForecastClient.mRestAdapter.create(IWeather.class);
        Call<Weather> hotelCall = iWeather.getWeather(String.valueOf(getWeatherEvent.getLatitude()), String.valueOf(getWeatherEvent.getLongitude()));
        asyncRequest(hotelCall);

    }


}
