package com.falin.valentin.realmexample.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.falin.valentin.realmexample.MainActivity;
import com.falin.valentin.realmexample.R;
import com.falin.valentin.realmexample.model.Model;
import com.falin.valentin.realmexample.presenter.Presenter;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ItemDataFragment extends Fragment {
    private TextView mainText;

    private Context context;

    public ItemDataFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        mainText = view.findViewById(R.id.item_edit_text);
        return view;
    }

    public void attachContext(Context context) {
        this.context = context;
    }
}
