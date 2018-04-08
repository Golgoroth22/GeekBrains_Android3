package com.falin.valentin.rxjava2training.presenter;

import android.view.View;

import com.falin.valentin.rxjava2training.model.Model;
import com.falin.valentin.rxjava2training.view.ViewFragment;

import io.reactivex.Observable;

public class Presenter {
    private Model model;
    private ViewFragment fragment;

    public Presenter(Model model) {
        this.model = model;
    }

    public void attachViewFragment(ViewFragment fragment) {
        this.fragment = fragment;
    }

    public void firstButtonClick() {
        Observable<String> stringObservable = model.getStringObservable();
        fragment.firstButtonClick(stringObservable);
    }

    public void secondButtonClick() {
        Observable<Integer> integerObservable = model.getIntegerObservable();
        fragment.secondButtonClick(integerObservable);
    }

    public void thirdButtonClicked() {
        Observable<Long> longObserver = model.getLongObserver();
        fragment.thirdButtonClicked(longObserver);
    }

    public void fourthButtonClicked() {
        fragment.fourthButtonClicked();
    }
}
