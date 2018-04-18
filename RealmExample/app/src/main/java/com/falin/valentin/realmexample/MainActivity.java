package com.falin.valentin.realmexample;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.falin.valentin.realmexample.view.DataFragment;

import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataFragment dataFragment = new DataFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_container, dataFragment);
        dataFragment.attachContext(this);
        dataFragment.initRealm();
        transaction.commit();
    }
}
