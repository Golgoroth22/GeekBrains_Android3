package com.falin.valentin.realmexample.model.data.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface RoomWeatherEntityDao {
    @Insert
    void insertAll(RoomWeatherEntity... newEntitys);

    @Query("SELECT * FROM roomweatherentity")
    List<RoomWeatherEntity> getAllRoomWeatherEntitys();

    @Query("SELECT * FROM roomweatherentity")
    Flowable<RoomWeatherEntity> getAllJavaRXRoomWeatherEntitys();

    @Delete
    void delete(RoomWeatherEntity roomWeatherEntity);
}
