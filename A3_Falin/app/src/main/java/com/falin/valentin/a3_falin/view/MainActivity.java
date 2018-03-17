package com.falin.valentin.a3_falin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.falin.valentin.a3_falin.R;
import com.falin.valentin.a3_falin.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener, Presenter.Callback {
    private Button btnCounter1;
    private Button btnCounter2;
    private Button btnCounter3;
    private ImageView imageView;
    private ProgressBar progressBar;
    private Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCounter1 = (Button) findViewById(R.id.btnCounter1);
        btnCounter2 = (Button) findViewById(R.id.btnCounter2);
        btnCounter3 = (Button) findViewById(R.id.btnCounter3);
        btnCounter1.setOnClickListener(this);
        btnCounter2.setOnClickListener(this);
        btnCounter3.setOnClickListener(this);
        progressBar = findViewById(R.id.btn1_progress_bar);
        progressBar.setVisibility(View.INVISIBLE);
        imageView = findViewById(R.id.btn1_status_image);
        imageView.setVisibility(View.INVISIBLE);
        mPresenter = new Presenter(this, this);
    }

    @Override
    public void onClick(View view) {
        int[] idMass = {R.id.btnCounter1, R.id.btnCounter2, R.id.btnCounter3};
        mPresenter.buttonClick(view.getId(), idMass);
    }

    @Override
    public void setButtonText(int btnIndex, int value) {
        switch (btnIndex) {
            case 1:
                btnCounter1.setText("Количество = " + value);
                break;
            case 2:
                btnCounter2.setText("Количество = " + value);
                break;
            case 3:
                btnCounter3.setText("Количество = " + value);
                break;
        }
    }

    public void startLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void callingBack() {
        imageView.setVisibility(View.VISIBLE);
    }
}
