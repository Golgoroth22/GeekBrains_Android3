package com.falin.valentin.rxjava2training.model;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Model {
    private Observable<String> stringObservable;
    private Observable<Integer> integerObservable;
    private Observable<Long> longObserver;
    private String count;
    private Callable<Integer> integerCallable;
    private String[] stringMass;

    public Model() {
        stringObservable = Observable.fromArray("One", "Two", "Three");
        integerObservable = Observable.range(10, 4);
        longObserver = Observable.interval(500, TimeUnit.MILLISECONDS);
        count = "1234";
        integerCallable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return longAction(count);
            }
        };
        stringMass = new String[]{"1", "2", "3", "4", "5", "6"};
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

    public Callable<Integer> getIntegerCallable() {
        return integerCallable;
    }

    public int longAction(String text) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(text);
    }

    public String[] getStringMass() {
        return stringMass;
    }
}
