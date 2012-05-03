package com.hexacta.hat.presentacion.mvc.tradicional;

import com.hexacta.hat.presentacion.mvc.tradicional.support.MouseSensor;
import com.hexacta.hat.presentacion.mvc.tradicional.support.Point;

public class ButtonController {

    private final ButtonView myView;

    private Callback myCallback;

    private final ButtonModel myButtonModel;

    public ButtonController(final ButtonView buttonView, final ButtonModel buttonModel, final Callback callback) {
        myView = buttonView;
        myCallback = callback;
        myButtonModel = buttonModel;
    }

    public void processEvents() {
        while (MouseSensor.leftButtonPressed()) {
            Point pointClick = MouseSensor.pointClick();
            if (myView.contains(pointClick) && myButtonModel.isSelected()) {
                doAction();
            }
        }
    }

    private void doAction() {
        myCallback.execute();
    }

    public void setCallback(final Callback callback) {
        myCallback = callback;
    }
}
