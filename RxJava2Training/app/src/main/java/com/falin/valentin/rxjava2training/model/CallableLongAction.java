package com.falin.valentin.rxjava2training.model;

import java.util.concurrent.Callable;

public class CallableLongAction implements Callable<Integer> {
    private final String data;

    public CallableLongAction(String data) {
        this.data = data;
    }

    @Override
    public Integer call() throws Exception {
        return Integer.parseInt(data);
    }
}
