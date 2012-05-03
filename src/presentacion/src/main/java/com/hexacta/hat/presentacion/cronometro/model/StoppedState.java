/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.model;

/**
 * Estado "frenado" del cronometro.
 * 
 * @author diego
 */
public class StoppedState extends ChronometerStateEmptyBehavior {

    @Override
    public void continuue(final Chronometer chronometer) {
        chronometer.timer.start();
        chronometer.changeStateToRunning();
    }

    @Override
    public void start(final Chronometer chronometer) {
        chronometer.reset();
        chronometer.startTimer();
        chronometer.changeStateToRunning();
    }

}
