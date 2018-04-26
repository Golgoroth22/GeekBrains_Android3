package com.falin.valentin.realmexample.model;

import com.falin.valentin.realmexample.model.data.FullWeatherData;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<FullWeatherData> weatherDataList;

    public Model() {
        this.weatherDataList = new ArrayList<>();
    }

    public List<FullWeatherData> getWeatherDataList() {
        return weatherDataList;
    }

    public void addNewCity(FullWeatherData newCityData) {
        this.weatherDataList.add(newCityData);
    }
}
