package com.falin.valentin.realmexample;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.falin.valentin.realmexample.view.ItemDataFragment;
import com.falin.valentin.realmexample.view.ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment listFragment = new ListFragment();
        //ItemDataFragment itemDataFragment = new ItemDataFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_container, listFragment);
//        itemDataFragment.attachContext(this);
//        itemDataFragment.initRealm();
        transaction.commit();
    }
}
