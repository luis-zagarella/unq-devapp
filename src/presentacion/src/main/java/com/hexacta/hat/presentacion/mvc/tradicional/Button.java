package com.hexacta.hat.presentacion.mvc.tradicional;

import com.hexacta.hat.presentacion.mvc.tradicional.support.Rectangle;

public class Button {

    private ButtonModel myModel;

    private ButtonView myView;

    private ButtonController myController;

    public Button(final String name, final Rectangle rectangle, final Callback callback) {
        myModel = new ButtonModel(name);
        myView = new ButtonView(rectangle, myModel);
        myController = new ButtonController(myView, myModel, callback);
    }

    // lo que sigue es para emular una Fluent Interface para crear botones

    public Button named(final String aName) {
        myModel.setName(aName);
        return this;
    }

    public Button fromPoint(final int i, final int j) {
        myView.setFromPoint(i, j);
        return this;
    }

    public Button toPoint(final int i, final int j) {
        myView.setToPoint(i, j);
        return this;
    }

    public Button with(final Callback callback) {
        myController.setCallback(callback);
        return this;
    }

    public Button() {
    }

    public static Button aButton() {
        return new Button();
    }

}
