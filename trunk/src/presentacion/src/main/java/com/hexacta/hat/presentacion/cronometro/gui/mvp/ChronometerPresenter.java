package com.hexacta.hat.presentacion.cronometro.gui.mvp;

import java.util.Observable;
import java.util.Observer;

import com.hexacta.hat.presentacion.cronometro.model.Chronometer;

public class ChronometerPresenter implements Observer {

    private ChronometerPassiveView myChronometerView;

    private Chronometer myChronometer;

    public static void startOn(final ChronometerPassiveView aChronometerView, final Chronometer aChronometer) {
        new ChronometerPresenter(aChronometerView, aChronometer);
    }

    public ChronometerPresenter(final ChronometerPassiveView aChronometerView, final Chronometer aChronometer) {
        bindTo(aChronometerView);
        bindTo(aChronometer);
    }

    private void bindTo(final ChronometerPassiveView aChronometerView) {
        myChronometerView = aChronometerView;
        myChronometerView.init(this);

        myChronometerView.enableOnlyStartCommand();
    }

    private void bindTo(final Chronometer aChronometer) {
        myChronometer = aChronometer;
        myChronometer.addObserver(this);
    }

    public void startChronometer() {
        myChronometerView.enableOnlyStopAndLapCommands();
        myChronometerView.changeDisplayColorToGray();

        myChronometer.start();
    }

    public void stopChronometer() {
        myChronometerView.enableOnlyStartAndContinueCommands();
        myChronometerView.changeDisplayColorToRed();

        myChronometer.stop();
    }

    public void continueChronometer() {
        myChronometerView.enableOnlyStopAndLapCommands();
        myChronometerView.changeDisplayColorToGray();

        myChronometer.continuue();
    }

    public void lapChronometer() {
        myChronometerView.enableOnlyStopAndContinueCommands();
        myChronometerView.changeDisplayColorToYellow();

        myChronometer.lap();
    }

    @Override
    public void update(final Observable o, final Object arg) {
        Integer seconds = (Integer) arg;

        myChronometerView.updateDisplayWith(seconds);
    }

}
