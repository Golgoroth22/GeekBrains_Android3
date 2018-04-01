package com.falin.valentin.a3_l2_falin.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;

import com.falin.valentin.a3_l2_falin.data.UserData;
import com.falin.valentin.a3_l2_falin.view.MainActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
        //new DownloadUserData().execute(baseUrl);
        this.urlBuilder = HttpUrl.parse(baseUrl).newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        ConnectivityManager connectivityManager = (ConnectivityManager) view.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            view.downloadOneUrl(request);
            //new DownloadPageTask().execute(request); // запускаем в новом потоке
        } else {
            Toast.makeText(view, "Подключите интернет", Toast.LENGTH_SHORT).show();
        }
    }

//    private String downloadUserInfo(String inputUrl) {
//        InputStream inputStream = null;
//        String data = "";
//        try {
//            URL url = new URL(inputUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setReadTimeout(100000);
//            connection.setConnectTimeout(100000);
//            connection.setRequestMethod("GET");
//            connection.setInstanceFollowRedirects(true);
//            connection.setUseCaches(false);
//            connection.setDoInput(true);
//            int responseCode = connection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                System.out.println("Request Method - " + connection.getRequestMethod());
//                System.out.println("Response Message -  " + connection.getResponseMessage());
//                Map<String, List<String>> stringListMap = connection.getHeaderFields();
//                Set<String> mapFields = stringListMap.keySet();
//                for (String s : mapFields) {
//                    System.out.println("Key - " + s + ", Value - " + stringListMap.get(s));
//                }
//                inputStream = connection.getInputStream();
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                int read = 0;
//                while ((read = inputStream.read()) != -1) {
//                    byteArrayOutputStream.write(read);
//                }
//                byte[] result = byteArrayOutputStream.toByteArray();
//                byteArrayOutputStream.close();
//                data = new String(result);
//            } else {
//                data = connection.getResponseMessage() + ". Error code - " + responseCode;
//            }
//            connection.disconnect();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        userData.setUserNickName(data);
//        return data;
//        return null;
//    }


}
