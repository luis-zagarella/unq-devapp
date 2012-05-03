/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.model;

/**
 * Implementaciones vacias de la interfaz, para que cada uno de los estados
 * concretos definan solo las acciones que tienen sentido..
 * 
 * @author diego
 */
public abstract class ChronometerStateEmptyBehavior implements ChronometerState {

    @Override
    public void continuue(final Chronometer chronometer) {
    }

    @Override
    public void lap(final Chronometer chronometer) {
    }

    @Override
    public void start(final Chronometer chronometer) {
    }

    @Override
    public void stop(final Chronometer chronometer) {
    }

    @Override
    public void update(final Chronometer chronometer, final Integer seconds) {

    }

}
