package com.falin.valentin.rxjava2training.model;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class Model {
    private Observable<String> stringObservable;
    private Observable<Integer> integerObservable;
    private Observable<Long> longObserver;

    public Model() {
        stringObservable = Observable.fromArray("One", "Two", "Three");
        integerObservable = Observable.range(10, 4);
        longObserver = Observable.interval(500, TimeUnit.MILLISECONDS);
    }

    public Observable<String> getStringObservable() {
        return stringObservable;
    }

    public Observable<Integer> getIntegerObservable() {
        return integerObservable;
    }

    public Observable<Long> getLongObserver() {
        return longObserver;
    }
}
