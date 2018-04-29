package com.falin.valentin.realmexample.model.data.retrofit;

import com.google.gson.annotations.SerializedName;

public class MoreWeatherData {
    @SerializedName("main")
    private String weatherType;
    @SerializedName("icon")
    private String iconId;

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }
}
