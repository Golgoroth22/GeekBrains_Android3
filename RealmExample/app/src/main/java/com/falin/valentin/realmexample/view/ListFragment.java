package com.falin.valentin.realmexample.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.falin.valentin.realmexample.R;
import com.falin.valentin.realmexample.model.Model;
import com.falin.valentin.realmexample.presenter.Presenter;

import java.util.List;

public class ListFragment extends Fragment {
    RecyclerView recyclerView;
    ItemListAdapter adapter;

    List<String> list;
    List<Double> weatherList;

    public ListFragment() {
    }

    public void attachPresenterAndModel(@NonNull Model model) {
        this.list = model.getTempList();
        this.weatherList = model.getTempDoubleList();
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
            holder.cityNameTextView.setText("  " + list.get(position));
            holder.weatherTextView.setText(weatherList.get(position) + " \u2103");
        }

        @Override
        public int getItemCount() {
            if (list.size() != 0) {
                return list.size();
            }
            return 0;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cityNameTextView;
        TextView weatherTextView;

        MyViewHolder(View itemView) {
            super(itemView);
            cityNameTextView = itemView.findViewById(R.id.list_item_text);
            weatherTextView = itemView.findViewById(R.id.list_item_weather);
        }
    }
}
