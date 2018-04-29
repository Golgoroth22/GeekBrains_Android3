package com.falin.valentin.realmexample.model.data.retrofit;

import com.falin.valentin.realmexample.model.data.retrofit.FullWeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitRestAPI {
    @GET("weather?units=metric")
    Call<FullWeatherData> loadWeather(@Query("q") String s, @Query("appid") String appid);
}
