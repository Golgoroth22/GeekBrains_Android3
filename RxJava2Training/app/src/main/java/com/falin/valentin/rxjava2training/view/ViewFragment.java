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
import com.falin.valentin.rxjava2training.model.Model;
import com.falin.valentin.rxjava2training.presenter.Presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class ViewFragment extends Fragment {
    Button firstButton;
    Button secondButton;
    Button thirdButton;
    Button fourthButton;
    Button fifthButton;
    Button sixthButton;
    TextView textView;
    ImageView imageView;

    Presenter presenter;


    public ViewFragment() {
        Model model = new Model();
        presenter = new Presenter(model);
        presenter.attachViewFragment(this);
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
                presenter.firstButtonClick();
            }
        });
        secondButton = view.findViewById(R.id.second_button);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.secondButtonClick();
            }
        });
        thirdButton = view.findViewById(R.id.third_button);
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.thirdButtonClicked();
            }
        });
        fourthButton = view.findViewById(R.id.fourth_button);
        fifthButton = view.findViewById(R.id.fifth_button);
        sixthButton = view.findViewById(R.id.sixth_button);
        textView = view.findViewById(R.id.text);
        imageView = view.findViewById(R.id.image);
    }

    private void clearTextView() {
        textView.setText("");
    }

    public void firstButtonClick(Observable<String> stringObservable) {
        clearTextView();
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
        stringObservable.subscribe(observer);
    }

    public void secondButtonClick(Observable<Integer> integerObservable) {
        clearTextView();
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
            }

            @Override
            public void onNext(Integer integer) {
                textView.append("- onNext method " + integer + "\n");
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
        integerObservable.subscribe(observer);
    }

    public void thirdButtonClicked(Observable<Long> longObserver) {
        clearTextView();
        Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
            }

            @Override
            public void onNext(Long aLong) {
                textView.append("- onNext method " + aLong + "\n");
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
        longObserver.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
