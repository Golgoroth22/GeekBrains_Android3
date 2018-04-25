package com.falin.valentin.realmexample.model;

import com.falin.valentin.realmexample.view.ListFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class Model {
    private String tempData;
    private List<String> tempList;
    private List<Double> tempDoubleList;

    public Model() {
        this.tempData = "";
        this.tempList = new ArrayList<>();
        this.tempDoubleList = new ArrayList<>();
        tempList.add("London");
        tempDoubleList.add(22.0);
    }

    public String getTempData() {
        return tempData;
    }

    public List<String> getTempList() {
        return tempList;
    }

    public List<Double> getTempDoubleList() {
        return tempDoubleList;
    }

    public void addNewCity(String cityName, double weather) {
        tempList.add(cityName);
        tempDoubleList.add(weather);
    }
}
