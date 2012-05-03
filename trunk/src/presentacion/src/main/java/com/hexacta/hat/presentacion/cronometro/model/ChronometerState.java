/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.model;

/**
 * Interfaz que debe cumplir un Estado del cronometro.
 * 
 * @author diego
 */
public interface ChronometerState {

    void start(Chronometer chronometer);

    void stop(Chronometer chronometer);

    void continuue(Chronometer chronometer);

    void lap(Chronometer chronometer);

    void update(Chronometer chronometer, Integer seconds);

}
