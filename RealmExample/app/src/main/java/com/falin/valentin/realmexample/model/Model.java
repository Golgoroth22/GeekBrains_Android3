package com.falin.valentin.realmexample.model;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.falin.valentin.realmexample.MainActivity;
import com.falin.valentin.realmexample.model.data.retrofit.FullWeatherData;
import com.falin.valentin.realmexample.model.data.room.RoomWeatherEntity;
import com.falin.valentin.realmexample.view.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<FullWeatherData> weatherDataList;
    private List<RoomWeatherEntity> roomWeatherEntityList;

    public Model() {
        this.weatherDataList = new ArrayList<>();
        this.roomWeatherEntityList = new ArrayList<>();
        new GetAllCities().execute();
    }

    public List<FullWeatherData> getWeatherDataList() {
        return weatherDataList;
    }

    public List<RoomWeatherEntity> getRoomWeatherEntityList() {
        return roomWeatherEntityList;
    }

    public void addNewCity(@NonNull FullWeatherData newCityData) {
        this.weatherDataList.add(newCityData);
    }

    public void addNewCityToRoom(@NonNull FullWeatherData newCityData) {
        RoomWeatherEntity entity = new RoomWeatherEntity(
                roomWeatherEntityList.size() + 2,
                newCityData.getCityName(),
                newCityData.getCityId(),
                newCityData.getMoreWeatherData().get(0).getIconId(),
                newCityData.getWeatherData().getTemperature());
        roomWeatherEntityList.add(entity);
        new AddNewCityTasc().execute(entity);
    }

    private class AddNewCityTasc extends AsyncTask<RoomWeatherEntity, Void, Void> {
        @Override
        protected Void doInBackground(RoomWeatherEntity... roomWeatherEntities) {
            MainActivity.getDatabase().getRoomWeatherEntityDao().insertAll(roomWeatherEntities[0]);
            return null;
        }
    }

    private class GetAllCities extends AsyncTask<Void, Void, List<RoomWeatherEntity>> {
        @Override
        protected List<RoomWeatherEntity> doInBackground(Void... voids) {
            List<RoomWeatherEntity> entitys = MainActivity.getDatabase().getRoomWeatherEntityDao().getAllRoomWeatherEntitys();
            ListFragment.weatherEntityList.addAll(entitys);
            return entitys;
        }
    }
}
