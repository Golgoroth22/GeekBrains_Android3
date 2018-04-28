package com.falin.valentin.realmexample.model.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FullWeatherData {
    @SerializedName("main")
    private MainWeatherData weatherData;
    @SerializedName("name")
    private String cityName;
    @SerializedName("id")
    private int cityId;
    @SerializedName("weather")
    private List<MoreWeatherData> moreWeatherData;

    public List<MoreWeatherData> getMoreWeatherData() {
        return moreWeatherData;
    }

    public void setMoreWeatherData(List<MoreWeatherData> moreWeatherData) {
        this.moreWeatherData = moreWeatherData;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

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
