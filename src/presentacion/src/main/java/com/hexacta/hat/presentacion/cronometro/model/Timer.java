/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.model;

import java.util.Observer;

/**
 * Interfaz de un timer.
 * 
 * @author diego
 * 
 */
public interface Timer extends Runnable {

    void start();

    void stop();

    void addObserver(Observer observer);

    void reset();

    boolean isRunning();

    Integer getCurrentSeconds();

}
