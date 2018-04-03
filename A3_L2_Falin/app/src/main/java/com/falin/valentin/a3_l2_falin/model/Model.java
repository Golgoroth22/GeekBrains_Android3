package com.falin.valentin.a3_l2_falin.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.falin.valentin.a3_l2_falin.data.RestAPI;
import com.falin.valentin.a3_l2_falin.data.RestAPIforUser;
import com.falin.valentin.a3_l2_falin.data.UserData;
import com.falin.valentin.a3_l2_falin.data.UserPojo;
import com.falin.valentin.a3_l2_falin.view.MainActivity;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {
    private String baseUrl = "https://api.github.com/";
    private String userLogin = "Golgoroth22";
    private HttpUrl.Builder urlBuilder;
    private static UserData userData;
    private RestAPI restAPI;
    private RestAPIforUser restAPIforUser;

    public UserData getUserData() {
        return userData;
    }

    public Model() {
        userData = new UserData();
    }

    public void loadUserData(MainActivity view) {
        Retrofit retrofit = null;
        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            this.restAPIforUser = retrofit.create(RestAPIforUser.class);
            //this.restAPI = retrofit.create(RestAPI.class);  For all users
        } catch (Exception e) {
            System.out.println("NO RETROFIT!");
            return;
        }
        Call<UserPojo> call = restAPIforUser.loadUserData(userLogin);
        ConnectivityManager connectivityManager = (ConnectivityManager) view.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            view.downloadOneUrl(call);
        } else {
            Toast.makeText(view, "Подключите интернет", Toast.LENGTH_SHORT).show();
        }
    }

//    public void loadUserData(MainActivity view) {
//        this.urlBuilder = HttpUrl.parse(baseUrl).newBuilder();
//        String url = urlBuilder.build().toString();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        ConnectivityManager connectivityManager = (ConnectivityManager) view.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        if (networkInfo != null && networkInfo.isConnected()) {
//            view.downloadOneUrl(request);
//        } else {
//            Toast.makeText(view, "Подключите интернет", Toast.LENGTH_SHORT).show();
//        }
//    }
}
