package com.falin.valentin.realmexample.model.data.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class RoomWeatherEntity {
    @PrimaryKey
    private int id;
    private String cityName;
    private int cityId;
    private String iconId;
    private double temperature;

    public RoomWeatherEntity() {
    }

    public RoomWeatherEntity(int id, String cityName, int cityId, String iconId, double temperature) {
        this.id = id;
        this.cityName = cityName;
        this.cityId = cityId;
        this.iconId = iconId;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
