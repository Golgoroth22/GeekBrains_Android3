package com.falin.valentin.realmexample.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.falin.valentin.realmexample.R;
import com.falin.valentin.realmexample.model.Model;
import com.falin.valentin.realmexample.presenter.Presenter;

public class DataFragment extends Fragment {
    private Presenter presenter;

    public DataFragment() {
        Model model = new Model();
        presenter = new Presenter(model);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_data, container, false);
    }
}
