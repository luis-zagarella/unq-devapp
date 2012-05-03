/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.model;

/**
 * Estado "en lap" del cronometro, cuando se le envio la accion LAP.
 * 
 * @author diego
 */
public class LapedState extends ChronometerStateEmptyBehavior {

    @Override
    public void stop(final Chronometer chronometer) {
        chronometer.currentSeconds = chronometer.timer.getCurrentSeconds();
        chronometer.timer.stop();
        chronometer.changed();
        chronometer.changeStateToStopped();
    }

    @Override
    public void continuue(final Chronometer chronometer) {
        chronometer.changeStateToRunning();
    }

}
