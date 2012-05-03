package com.hexacta.hat.presentacion.mvc.tradicional;

import java.util.Observable;
import java.util.Observer;

import com.hexacta.hat.presentacion.mvc.tradicional.support.Point;
import com.hexacta.hat.presentacion.mvc.tradicional.support.Rectangle;

public class ButtonView implements Observer {

    private final Rectangle myRectangle;

    public ButtonView(final Rectangle rectangle, final ButtonModel buttonModel) {
        myRectangle = rectangle;
        buttonModel.addObserver(this);
    }

    @Override
    public void update(final Observable o, final Object arg) {
        ButtonModel buttonModel = (ButtonModel) o;
        if (buttonModel.isSelected()) {
            drawSeleted();
        } else {
            drawDeseleted();
        }
    }

    private void drawSeleted() {
        // se dibuja en modo seleccionado
    }

    private void drawDeseleted() {
        // se dibuja en modo des-seleccionado
    }

    public boolean contains(final Point aPoint) {
        return myRectangle.contains(aPoint);
    }

    public void setFromPoint(final int i, final int j) {
        throw new UnsupportedOperationException();
    }

    public void setToPoint(final int i, final int j) {
        throw new UnsupportedOperationException();
    }

}
