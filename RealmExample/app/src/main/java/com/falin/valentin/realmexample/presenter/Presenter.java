package com.falin.valentin.realmexample.presenter;

import android.support.annotation.NonNull;

import com.falin.valentin.realmexample.MainActivity;
import com.falin.valentin.realmexample.model.Model;
import com.falin.valentin.realmexample.model.data.WeatherDataLoader;

public class Presenter {
    private boolean isList = true;
    private Model model;
    private MainActivity context;

    public Presenter(Model model) {
        this.model = model;
    }

    public void attachContext(@NonNull MainActivity context) {
        this.context = context;
    }

    public void buttonClicked() {
        if (isList) {
            context.changeFragmentToItemView();
            isList = false;
        } else {
            context.changeFragmentToListView();
            isList = true;
        }
    }

    public void addButtonClicked(String cityName) {
        WeatherDataLoader.getWeatherData(context, cityName, model);
//        WeatherDataLoader.getJSONWeatherData(context, cityName, model);
    }

    public void clearButtonClicked() {
        // TODO: 26.04.2018  
    }
}
