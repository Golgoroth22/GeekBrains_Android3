package com.falin.valentin.a3_l2_falin.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.falin.valentin.a3_l2_falin.view.MainActivity;
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
        ConnectivityManager connectivityManager = (ConnectivityManager) view.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            view.showProgressBar();
            String tempNickName = model.getUserData().getUserNickName();
            model.loadUserData();
            while (true) {
                String currentNickName = model.getUserData().getUserNickName();
                if (tempNickName.equals(currentNickName)) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                view.changeNickName(currentNickName);
                view.hideProgressBar();
                break;
            }
        } else {
            Toast.makeText(view, "INTERNET DISABLED", Toast.LENGTH_LONG).show();
        }
    }
}
