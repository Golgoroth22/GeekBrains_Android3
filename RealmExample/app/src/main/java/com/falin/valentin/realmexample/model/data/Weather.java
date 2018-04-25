package com.falin.valentin.realmexample.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Weather {
    @SerializedName("temp")
    private double temperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
