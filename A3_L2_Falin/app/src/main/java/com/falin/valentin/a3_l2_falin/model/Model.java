package com.falin.valentin.a3_l2_falin.model;

import com.falin.valentin.a3_l2_falin.data.UserData;

public class Model {
    private UserData userData;

    public Model() {
        this.userData = new UserData();
    }

    public String loadUserData() {
        userData.setUserNickName("newNickName");
        return userData.getUserNickName();
    }
}
