package com.falin.valentin.realmexample.model.data;

import com.falin.valentin.realmexample.MainActivity;
import com.google.gson.annotations.SerializedName;

public class FullWeatherData {
    @SerializedName("main")
    private MainWeatherData weatherData;
    @SerializedName("name")
    private String cityName;

    public MainWeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(MainWeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
