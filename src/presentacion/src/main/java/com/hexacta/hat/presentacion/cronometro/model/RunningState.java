/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.model;

/**
 * Estado "Corriendo" del cronometro, pasan los segundos.
 * 
 * @author diego
 */
public class RunningState extends ChronometerStateEmptyBehavior {

    @Override
    public void stop(final Chronometer chronometer) {
        chronometer.timer.stop();
        chronometer.changeStateToStopped();
    }

    @Override
    public void lap(final Chronometer chronometer) {
        chronometer.changeStateToLapped();
    }

    @Override
    public void update(final Chronometer chronometer, final Integer seconds) {
        chronometer.currentSeconds = seconds;
        chronometer.changed();
    }
}
