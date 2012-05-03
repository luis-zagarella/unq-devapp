package com.hexacta.hat.presentacion.mvc.tradicional.support;

@SuppressWarnings("unused")
public class Rectangle {

    private Point fromPoint;

    private Point toPoint;

    public boolean contains(final Point aPoint) {
        throw new UnsupportedOperationException();
    }

    public Rectangle fromPoint(final int i, final int j) {
        fromPoint = new Point(i, j);
        return this;
    }

    public Rectangle toPoint(final int i, final int j) {
        toPoint = new Point(i, j);
        return this;
    }

}
