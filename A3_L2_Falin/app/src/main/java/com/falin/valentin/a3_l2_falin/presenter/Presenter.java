package com.falin.valentin.a3_l2_falin.presenter;

import com.falin.valentin.a3_l2_falin.MainActivity;
import com.falin.valentin.a3_l2_falin.data.UserData;
import com.falin.valentin.a3_l2_falin.model.Model;

public class Presenter {
    private MainActivity view;
    private Model model;

    public Presenter(Model model) {
        this.model = model;
    }

    public void attachView(MainActivity activity) {
        this.view = activity;
    }

    public void detachView() {
        this.view = null;
    }

    public void loadButtonClick() {
        String userName = model.loadUserData();
        view.changeNickName(userName);
    }
}
