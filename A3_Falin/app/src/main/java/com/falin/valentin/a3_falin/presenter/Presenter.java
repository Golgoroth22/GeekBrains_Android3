package com.falin.valentin.a3_falin.presenter;

import com.falin.valentin.a3_falin.model.Model;
import com.falin.valentin.a3_falin.view.MainActivity;

public class Presenter {
    private Model mModel;
    private MainActivity view;

    public Presenter(MainActivity view) {
        this.mModel = new Model();
        this.view = view;
    }

    private int calcNewModelValue(int modelElementIndex) {
        int currentValue = mModel.getElementValueAtIndex(modelElementIndex);
        return currentValue + 1;
    }

    public void buttonClick(int btnIndex) {
        int newModelValue;
        switch (btnIndex) {
            case R.id.btnCounter1:
                newModelValue = calcNewModelValue(0);
                mModel.setElementValueAtIndex(0, newModelValue);
                view.setButtonText(1, newModelValue);
                break;
            case R.id.btnCounter2:
                newModelValue = calcNewModelValue(1);
                mModel.setElementValueAtIndex(1, newModelValue);
                view.setButtonText(2, newModelValue);
                break;
            case R.id.btnCounter3:
                newModelValue = calcNewModelValue(2);
                mModel.setElementValueAtIndex(2, newModelValue);
                view.setButtonText(3, newModelValue);
                break;
        }
    }

}
