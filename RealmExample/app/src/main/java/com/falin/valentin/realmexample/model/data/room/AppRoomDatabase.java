package com.falin.valentin.realmexample.model.data.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {RoomWeatherEntity.class}, version = 1)
public abstract class AppRoomDatabase extends RoomDatabase {
    public abstract RoomWeatherEntityDao getRoomWeatherEntityDao();
}
