package com.falin.valentin.realmexample.model.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestAPI {
    @GET("weather?units=metric")
    Call<FullWeatherData> loadWeather(@Query("q") String s, @Query("appid") String appid);
}
