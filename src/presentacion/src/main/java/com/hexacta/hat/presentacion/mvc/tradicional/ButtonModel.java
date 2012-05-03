package com.hexacta.hat.presentacion.mvc.tradicional;

import java.util.Observable;

public class ButtonModel extends Observable {

    private boolean selected;

    private String name;

    public ButtonModel(final String name) {
        this.name = name;
        selected = false;
    }

    public void select() {
        selected = true;
        changed();
    }

    public void deselect() {
        selected = false;
        changed();
    }

    public boolean isSelected() {
        return selected;
    }

    public String name() {
        return name;
    }

    private void changed() {
        setChanged();
        notifyObservers();
    }

    public void setName(final String aName) {
        name = aName;
    }

}
