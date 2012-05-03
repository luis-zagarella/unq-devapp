/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.model;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Modela un cronometro que puede comenzar, parar, y marcar vueltas.
 * 
 * @author diego
 */
public class Chronometer extends Observable implements Observer {

    Timer timer;

    Integer currentSeconds;

    ExecutorService threadExecutor;

    private ChronometerState state;

    private final LapedState lappedState;

    private final RunningState runningState;

    private final StoppedState stoppedState;

    public Chronometer() {
        currentSeconds = 0;
        lappedState = new LapedState();
        runningState = new RunningState();
        stoppedState = new StoppedState();
        state = stoppedState;
        threadExecutor = Executors.newSingleThreadExecutor();
        timer = new SecondsTimer();
        timer.addObserver(this);
    }

    public void start() {
        state.start(this);
    }

    public Integer getSeconds() {
        return currentSeconds;
    }

    @Override
    public void update(final Observable o, final Object arg) {
        assert arg instanceof Integer;
        state.update(this, (Integer) arg);
    }

    public void changed() {
        setChanged();
        this.notifyObservers(currentSeconds);
    }

    public void stop() {
        state.stop(this);
    }

    public void lap() {
        state.lap(this);
    }

    public void continuue() {
        state.continuue(this);
    }

    void changeStateToLapped() {
        state = lappedState;
    }

    void changeStateToRunning() {
        state = runningState;
    }

    void changeStateToStopped() {
        state = stoppedState;
    }

    public void reset() {
        timer.reset();
    }

    public void startTimer() {
        if (!timer.isRunning()) {
            threadExecutor.execute(timer);
        }
        timer.start();
    }

}
