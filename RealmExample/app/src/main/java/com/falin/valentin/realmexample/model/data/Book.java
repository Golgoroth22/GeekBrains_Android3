package com.falin.valentin.realmexample.model.data;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class Book extends RealmObject {
    @Required
    private String Title;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
