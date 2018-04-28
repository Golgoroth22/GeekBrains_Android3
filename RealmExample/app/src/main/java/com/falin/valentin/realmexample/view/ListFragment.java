package com.falin.valentin.realmexample.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.falin.valentin.realmexample.R;
import com.falin.valentin.realmexample.model.Model;
import com.falin.valentin.realmexample.model.data.FullWeatherData;
import com.falin.valentin.realmexample.model.data.WeatherDataLoader;
import com.falin.valentin.realmexample.presenter.Presenter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListFragment extends Fragment {
    RecyclerView recyclerView;
    ItemListAdapter adapter;

    List<FullWeatherData> weatherData;

    public ListFragment() {
    }

    public void attachPresenterAndModel(@NonNull Model model) {
        this.weatherData = model.getWeatherDataList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        initRecycler(view);
        return view;
    }

    private void initRecycler(View view) {
        recyclerView = view.findViewById(R.id.list_item_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new ItemListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private class ItemListAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.cityNameTextView.setText("  " + weatherData.get(position).getCityName());
            holder.weatherTextView.setText(weatherData.get(position).getWeatherData().getTemperature() + " \u2103 ");

            StringBuilder weatherIconUrl = new StringBuilder(WeatherDataLoader.OPEN_WEATHER_ICON_URL_PREFIX)
                    .append(weatherData.get(position).getMoreWeatherData().get(0).getIconId())
                    .append(WeatherDataLoader.OPEN_WEATHER_ICON_URL_POSTFIX);
            Picasso.get()
                    .load(weatherIconUrl.toString())
                    .resize(32, 32)
                    .into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            if (weatherData.size() != 0) {
                return weatherData.size();
            }
            return 0;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cityNameTextView;
        TextView weatherTextView;
        ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.list_item_image);
            cityNameTextView = itemView.findViewById(R.id.list_item_text);
            weatherTextView = itemView.findViewById(R.id.list_item_weather);
        }
    }
}
