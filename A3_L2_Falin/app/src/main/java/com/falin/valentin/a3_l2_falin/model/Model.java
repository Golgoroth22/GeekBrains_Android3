package com.falin.valentin.a3_l2_falin.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.falin.valentin.a3_l2_falin.data.UserData;
import com.falin.valentin.a3_l2_falin.view.MainActivity;

import okhttp3.HttpUrl;
import okhttp3.Request;

public class Model {
    private String baseUrl = "https://api.github.com/users/mojombo";
    private HttpUrl.Builder urlBuilder;
    private static UserData userData;

    public UserData getUserData() {
        return userData;
    }

    public Model() {
        userData = new UserData();
    }

    public void loadUserData(MainActivity view) {
        this.urlBuilder = HttpUrl.parse(baseUrl).newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        ConnectivityManager connectivityManager = (ConnectivityManager) view.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            view.downloadOneUrl(request);
        } else {
            Toast.makeText(view, "Подключите интернет", Toast.LENGTH_SHORT).show();
        }
    }
}
