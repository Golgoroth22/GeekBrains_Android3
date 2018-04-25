package com.falin.valentin.realmexample.presenter;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.falin.valentin.realmexample.MainActivity;
import com.falin.valentin.realmexample.model.Model;
import com.falin.valentin.realmexample.model.data.WeatherDataLoader;

import java.util.List;

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

    public List<String> getListData() {
        return model.getTempList();
    }

    public void addButtonClicked(String cityName) {
//        model.getTempList().add(cityName);
//        model.addNewCity(cityName);
//        WeatherDataLoader.getWeatherData(context, cityName);
        WeatherDataLoader.getJSONWeatherData(context, cityName, model);
    }

    public void clearButtonClicked() {
        model.getTempList().clear();
    }
}
