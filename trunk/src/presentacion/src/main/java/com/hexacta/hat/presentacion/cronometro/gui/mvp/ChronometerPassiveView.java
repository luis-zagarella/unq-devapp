package com.hexacta.hat.presentacion.cronometro.gui.mvp;

public interface ChronometerPassiveView {

    void enableOnlyStartCommand();

    void enableOnlyStopAndLapCommands();

    void enableOnlyStartAndContinueCommands();

    void enableOnlyStopAndContinueCommands();

    void changeDisplayColorToGray();

    void changeDisplayColorToRed();

    void changeDisplayColorToYellow();

    void updateDisplayWith(Integer seconds);

    void init(final ChronometerPresenter aChronometerPresenter);
}
