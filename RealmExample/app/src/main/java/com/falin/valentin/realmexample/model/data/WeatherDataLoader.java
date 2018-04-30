package com.falin.valentin.realmexample.model.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.falin.valentin.realmexample.model.Model;
import com.falin.valentin.realmexample.model.data.retrofit.FullWeatherData;
import com.falin.valentin.realmexample.model.data.retrofit.RetrofitRestAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherDataLoader {
    private static final String OPEN_WEATHER_MAP_API_METRIC = "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric";
    private static final String OPEN_WEATHER_MAP_API = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "17caaf60d16c4528b56b46666e0ab108";
    public static String OPEN_WEATHER_ICON_URL_PREFIX = "http://openweathermap.org/img/w/";
    public static String OPEN_WEATHER_ICON_URL_POSTFIX = ".png";
    private static final String KEY = "x-api-key";
    private static final String RESPONSE = "cod";
    private static final int All_GOOD = 200;

    private static RetrofitRestAPI restAPI;

    public static void getWeatherData(Context context, String city, Model model) {
        Retrofit retrofit = null;
        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(OPEN_WEATHER_MAP_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            restAPI = retrofit.create(RetrofitRestAPI.class);
        } catch (Exception e) {
            System.out.println("No retrofit " + e.getLocalizedMessage());
            return;
        }
        Call<FullWeatherData> call = restAPI.loadWeather(city, API_KEY);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            try {
                loadWeatherData(call, model);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            Toast.makeText(context, "no internet", Toast.LENGTH_SHORT).show();
        }
    }

    private static void loadWeatherData(Call<FullWeatherData> call, Model model) {
        call.enqueue(new Callback<FullWeatherData>() {
            @Override
            public void onResponse(Call<FullWeatherData> call, Response<FullWeatherData> response) {
                if (response.isSuccessful()) {
                    model.addNewCityToRoom(response.body());
                }
            }

            @Override
            public void onFailure(Call<FullWeatherData> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

//    static JSONObject getJSONData(Context context, String city) {
//        try {
//            URL url = new URL(String.format(OPEN_WEATHER_MAP_API_METRIC, city));
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.addRequestProperty(KEY, context.getString(R.string.open_weather_maps_api_key));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuilder stringBuilder = new StringBuilder(1024);
//            String tempString;
//            while ((tempString = reader.readLine()) != null) {
//                stringBuilder.append(tempString).append("\n");
//            }
//            reader.close();
//            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
//            if (jsonObject.getInt(RESPONSE) != All_GOOD) {
//                return null;
//            }
//            return jsonObject;
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static void getJSONWeatherData(Context context, String city, Model model) {
//        final Handler handler = new Handler();
//        new Thread() {
//            @Override
//            public void run() {
//                final JSONObject json = getJSONData(context, city);
//                if (json == null) {
//                    handler.post(() -> Toast.makeText(context, "json == null", Toast.LENGTH_SHORT).show());
//                } else {
//                    handler.post(() -> addNewCityToList(json, model));
//                }
//            }
//        }.start();
//    }
//
//    private static void addNewCityToList(JSONObject json, Model model) {
//        try {
//            JSONObject mainObject = json.getJSONObject("main");
//            double aDouble = mainObject.getDouble("temp");
//            String name = json.getString("name");
//            model.addNewCity(name, aDouble);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
}
