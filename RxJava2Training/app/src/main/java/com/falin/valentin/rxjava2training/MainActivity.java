package com.falin.valentin.rxjava2training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.falin.valentin.rxjava2training.view.ViewFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewFragment viewFragment = new ViewFragment();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, viewFragment);
        transaction.commit();
    }
}
