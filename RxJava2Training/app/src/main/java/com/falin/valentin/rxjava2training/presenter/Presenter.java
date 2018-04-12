package com.falin.valentin.rxjava2training.presenter;

import com.falin.valentin.rxjava2training.model.Model;
import com.falin.valentin.rxjava2training.view.ViewFragment;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

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
        fragment.fourthButtonClicked(model.getIntegerCallable());
    }

    public void fifthButtonClicked() {
        String[] stringMass = model.getStringMass();
        fragment.fifthButtonClicked(stringMass);
    }

    public void sixthButtonClicked() {
        Integer[] integerMass = model.getIntegerMass();
        fragment.sixButtonClicked(integerMass);
    }

    public void seventhButtonClicked() {
        fragment.seventhButtonClicked(model.getIntegerMass());
    }

    public void eighthButtonClicked() {
        fragment.eighthButtonClicked(model.getIntegerMass());
    }

    public void ninthButtonClicked() {
        fragment.ninthButtonClicked(model.getIntegerDuplicateMass());
    }

    public void tenthButtonClicked() {
        Predicate<String> predicate = s -> !(s.equals("1") || s.equals("3"));
        fragment.tenthButtonClicked(predicate, model.getStringMass());
    }

    public void eleventhButtonClicked() {
        fragment.eleventhButtonClicked(model.getIntegerMass(), model.getIntegerDuplicateMass());
    }
}
