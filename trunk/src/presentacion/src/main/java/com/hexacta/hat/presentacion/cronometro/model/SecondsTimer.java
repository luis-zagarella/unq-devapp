/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.model;

import java.util.Observable;

/**
 * Timer que avanza con cada segundo.
 * 
 * @author diego
 */
public class SecondsTimer extends Observable implements Timer {

    private static final int ONE_SECOND = 1000;

    private Integer currentValue = 0;

    private volatile boolean isStopped = false;

    private volatile boolean isRunning = false;

    private void changed() {
        setChanged();
        notifyObservers(currentValue);
    }

    private void incCurrentValue() {
        currentValue++;
        changed();
    }

    @Override
    public void reset() {
        currentValue = 0;
        changed();
    }

    @Override
    public void run() {
        init();
        while (true) {
            sleepOneSecond();
            if (!isStopped) {
                incCurrentValue();
            }
        }
    }

    private void init() {
        isRunning = true;
        nameTheThread();
    }

    private void sleepOneSecond() {
        try {
            Thread.sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void nameTheThread() {
        Thread.currentThread().setName("Seconds Timer");
    }

    @Override
    public void start() {
        isStopped = false;
    }

    @Override
    public void stop() {
        isStopped = true;
        changed();
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public Integer getCurrentSeconds() {
        return currentValue;
    }

}
