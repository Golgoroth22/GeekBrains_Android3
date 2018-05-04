package com.falin.valentin.realmexample;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.falin.valentin.realmexample.model.Model;
import com.falin.valentin.realmexample.presenter.Presenter;
import com.falin.valentin.realmexample.view.ItemDataFragment;
import com.falin.valentin.realmexample.view.ListFragment;

public class MainActivity extends AppCompatActivity {
    private Button previousButton;
    private Button forwardButton;

    private static Model model;
    private Presenter presenter;

    //public static AppRoomDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        model = new Model();
        presenter = new Presenter(model);
        previousButton = findViewById(R.id.main_previous_button);
        previousButton.setOnClickListener(v -> presenter.buttonClicked());
        forwardButton = findViewById(R.id.main_forward_button);
        forwardButton.setOnClickListener(v -> presenter.buttonClicked());

        ListFragment listFragment = new ListFragment();
        listFragment.attachModel(model, presenter);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_container, listFragment);
        transaction.commit();

        presenter.attachContext(this);
    }

    public void changeFragmentToItemView() {
        ItemDataFragment fragment = new ItemDataFragment();
        fragment.attachContextAndPresenter(presenter);
        attachFragment(fragment);
    }

    public void changeFragmentToListView() {
        ListFragment fragment = new ListFragment();
        fragment.attachModel(model, presenter);
        attachFragment(fragment);
    }

    private void attachFragment(@NonNull Fragment fragment) {
        View fragmentContainer = findViewById(R.id.main_container);
        if (fragmentContainer != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(null);
            transaction.replace(R.id.main_container, fragment);
            transaction.commit();
        }
    }
}
