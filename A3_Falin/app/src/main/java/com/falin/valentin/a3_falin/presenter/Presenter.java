package com.falin.valentin.a3_falin.presenter;

import android.view.View;

import com.falin.valentin.a3_falin.model.Model;
import com.falin.valentin.a3_falin.view.MainActivity;

import java.util.List;

public class Presenter {
    public interface Callback {
        void callingBack();
    }

    private Model mModel;
    private MainActivity view;
    private Callback callback;

    public Presenter(MainActivity view, Callback callback) {
        this.mModel = new Model();
        this.callback = callback;
        this.view = view;
    }

    private int calcNewModelValue(int modelElementIndex) {
        int currentValue = mModel.getElementValueAtIndex(modelElementIndex);
        return currentValue + 1;
    }

    public void buttonClick(int btnIndex, int[] list) {
        int newModelValue;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == btnIndex) {
                newModelValue = calcNewModelValue(i);
                mModel.setElementValueAtIndex(i, newModelValue);
                view.setButtonText(i + 1, newModelValue);
                if (i == 0) {
                    view.startLoading();
                    callback.callingBack();
                }
            }
        }
    }
}
