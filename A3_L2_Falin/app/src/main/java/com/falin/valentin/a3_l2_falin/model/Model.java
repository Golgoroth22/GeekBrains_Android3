package com.falin.valentin.a3_l2_falin.model;

import android.net.ConnectivityManager;
import android.os.AsyncTask;

import com.falin.valentin.a3_l2_falin.data.UserData;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Model {
    private String baseUrl = "https://api.github.com/users/mojombo";
    private UserData userData;

    public UserData getUserData() {
        return userData;
    }

    public Model() {
        userData = new UserData();
        userData.setUserNickName("Empty");
    }

    public void loadUserData() {
        new DownloadUserData().execute(baseUrl);
    }

    private class DownloadUserData extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            userData.setUserNickName(s);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + s);
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            return downloadUserInfo(strings[0]);
        }
    }

    private static String downloadUserInfo(String inputUrl) {
        InputStream inputStream = null;
        String data = "";
        try {
            URL url = new URL(inputUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(100000);
            connection.setConnectTimeout(100000);
            connection.setRequestMethod("GET");
            connection.setInstanceFollowRedirects(true);
            connection.setUseCaches(false);
            connection.setDoInput(true);
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Request Method - " + connection.getRequestMethod());
                System.out.println("Response Message -  " + connection.getResponseMessage());
                Map<String, List<String>> stringListMap = connection.getHeaderFields();
                Set<String> mapFields = stringListMap.keySet();
                for (String s : mapFields) {
                    System.out.println("Key - " + s + ", Value - " + stringListMap.get(s));
                }
                inputStream = connection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int read = 0;
                while ((read = inputStream.read()) != -1) {
                    byteArrayOutputStream.write(read);
                }
                byte[] result = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                data = new String(result);
                System.out.println("?????????????????");
            } else {
                data = connection.getResponseMessage() + ". Error code - " + responseCode;
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("!?!?!??!?!?!!?!?");
        return data;
    }
}
