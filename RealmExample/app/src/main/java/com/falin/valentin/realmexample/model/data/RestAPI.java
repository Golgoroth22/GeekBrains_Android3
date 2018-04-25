package com.falin.valentin.realmexample.model.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestAPI {
//    @GET("weather?q=%{city}&units=metric")
//    Call<Weather> loadWeather(@Path("city") String s);

    @GET("weather?q={city}")
    Call<Weather> loadWeather(@Path("city") String s);

}
