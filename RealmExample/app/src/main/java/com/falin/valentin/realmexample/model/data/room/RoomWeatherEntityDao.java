package com.falin.valentin.realmexample.model.data.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RoomWeatherEntityDao {
    @Insert
    void insertAll(RoomWeatherEntity... newEntitys);

    @Query("SELECT * FROM roomweatherentity")
    List<RoomWeatherEntity> getAllRoomWeatherEntitys();
}
