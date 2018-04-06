package com.falin.valentin.rxjava2training.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.falin.valentin.rxjava2training.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class ViewFragment extends Fragment {
    Button firstButton;
    Button secondButton;
    Button thirdButton;
    TextView textView;
    ImageView imageView;


    public ViewFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        firstButton = view.findViewById(R.id.first_button);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstButtonClick();
            }
        });
        secondButton = view.findViewById(R.id.second_button);
        thirdButton = view.findViewById(R.id.third_button);
        textView = view.findViewById(R.id.text);
        imageView = view.findViewById(R.id.image);
    }

    private void firstButtonClick() {
        Observable<String> observable = Observable.fromArray("One", "Two", "Three");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
            }

            @Override
            public void onNext(String s) {
                textView.append("- onNext method " + s + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        observable.subscribe(observer);
    }
}
