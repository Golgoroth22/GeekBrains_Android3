package com.falin.valentin.realmexample.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.falin.valentin.realmexample.MainActivity;
import com.falin.valentin.realmexample.R;
import com.falin.valentin.realmexample.presenter.Presenter;

public class ItemDataFragment extends Fragment {
    private EditText mainEditText;
    private Button addButton;

    private Presenter presenter;

    public ItemDataFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        mainEditText = view.findViewById(R.id.item_edit_text);
        addButton = view.findViewById(R.id.item_add_button);
        addButton.setOnClickListener(view1 -> {
            String cityName = mainEditText.getText().toString();
            presenter.addButtonClicked(cityName);
            mainEditText.setText("");
        });
        return view;
    }

    public void attachContextAndPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
