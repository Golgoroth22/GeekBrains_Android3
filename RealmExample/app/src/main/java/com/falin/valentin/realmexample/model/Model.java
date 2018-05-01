package com.falin.valentin.realmexample.model;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.falin.valentin.realmexample.MainActivity;
import com.falin.valentin.realmexample.model.data.retrofit.FullWeatherData;
import com.falin.valentin.realmexample.model.data.room.AppRoomDatabase;
import com.falin.valentin.realmexample.model.data.room.RoomWeatherEntity;
import com.falin.valentin.realmexample.view.ListFragment;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class Model {
    private static String DATABASE_NAME = "database10";
    private AppRoomDatabase roomDatabase;
    private List<RoomWeatherEntity> roomWeatherEntityList;

    public Model() {
        this.roomWeatherEntityList = new ArrayList<>();
//        new GetAllCities().execute();
//        MainActivity.getDatabase().getRoomWeatherEntityDao().getAllJavaRXRoomWeatherEntitys()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(roomWeatherEntity -> ListFragment.weatherEntityList.add(roomWeatherEntity));
    }

    public List<RoomWeatherEntity> getRoomWeatherEntityList() {
        return roomWeatherEntityList;
    }

    public void initRoomDatabase(Context context) {
        this.roomDatabase = Room
                .databaseBuilder(context, AppRoomDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    public void loadDataFromDatabase() {
        new GetAllCities().execute();
    }

    public void addNewEntityToDatabase(@NonNull FullWeatherData newCityData) {
        RoomWeatherEntity entity = new RoomWeatherEntity(
                newCityData.getCityName(),
                newCityData.getCityId(),
                newCityData.getMoreWeatherData().get(0).getIconId(),
                newCityData.getWeatherData().getTemperature());
        roomWeatherEntityList.add(entity);
        new AddNewCityTasc().execute(entity);
    }

    public void deleteElementFromDatabase(RoomWeatherEntity roomWeatherEntity) {
        new DeleteCity().execute(roomWeatherEntity);
    }

    private class AddNewCityTasc extends AsyncTask<RoomWeatherEntity, Void, Void> {
        @Override
        protected Void doInBackground(RoomWeatherEntity... roomWeatherEntities) {
            roomDatabase.getRoomWeatherEntityDao().insertAll(roomWeatherEntities[0]);
            return null;
        }
    }

    private class GetAllCities extends AsyncTask<Void, Void, List<RoomWeatherEntity>> {
        @Override
        protected List<RoomWeatherEntity> doInBackground(Void... voids) {
            List<RoomWeatherEntity> entitys = roomDatabase.getRoomWeatherEntityDao().getAllRoomWeatherEntitys();
            roomWeatherEntityList.addAll(entitys);
            return entitys;
        }
    }

    private class DeleteCity extends AsyncTask<RoomWeatherEntity, Void, RoomWeatherEntity> {
        @Override
        protected RoomWeatherEntity doInBackground(RoomWeatherEntity... roomWeatherEntities) {
            roomDatabase.getRoomWeatherEntityDao().delete(roomWeatherEntities[0]);
            return roomWeatherEntities[0];
        }

        @Override
        protected void onPostExecute(RoomWeatherEntity roomWeatherEntity) {
            super.onPostExecute(roomWeatherEntity);
            roomWeatherEntityList.remove(roomWeatherEntity);
        }
    }
}
