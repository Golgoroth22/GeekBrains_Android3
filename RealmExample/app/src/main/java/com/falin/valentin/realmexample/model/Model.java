package com.falin.valentin.realmexample.model;

import com.falin.valentin.realmexample.view.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private String tempData;
    private List<String> tempList;

    public Model() {
        this.tempData = "";
        this.tempList = new ArrayList<>();
        tempList.add("1111111");
        tempList.add("2222222");
    }

    public String getTempData() {
        return tempData;
    }

    public List<String> getTempList() {
        return tempList;
    }
}
