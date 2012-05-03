package com.hexacta.hat.presentacion.cronometro.gui.mvp;

import static org.mockito.Mockito.*;

import org.junit.Test;

import com.hexacta.hat.presentacion.cronometro.model.Chronometer;

public class ChronometerWindowPresenterTest {

    private final Chronometer aChronometer = mock(Chronometer.class);

    @Test
    public void onlyStartCmdShouldBeEnabledAtFirst() throws Exception {
        ChronometerPassiveView mockView = mock(ChronometerPassiveView.class);

        ChronometerPresenter.startOn(mockView, aChronometer);

        verify(mockView).enableOnlyStartCommand();
    }

    @Test
    public void whenStartedOnlyStopAndLapCmdsShouldBeEnabled() throws Exception {
        ChronometerPassiveView mockView = mock(ChronometerPassiveView.class);

        ChronometerPresenter chronoPresenter = newPresenterOn(mockView);

        chronoPresenter.startChronometer();

        verify(mockView).enableOnlyStopAndLapCommands();
    }

    @Test
    public void whenStoppedOnlyStartAndContinueCmdsShouldBeEnabled() throws Exception {
        ChronometerPassiveView mockView = mock(ChronometerPassiveView.class);

        ChronometerPresenter chronoPresenter = newPresenterOn(mockView);

        chronoPresenter.startChronometer();
        chronoPresenter.stopChronometer();

        verify(mockView).enableOnlyStartAndContinueCommands();
    }

    @Test
    public void whenContinuedOnlyStopAndLapCmdsShouldBeEnabled() throws Exception {
        ChronometerPassiveView mockView = mock(ChronometerPassiveView.class);

        ChronometerPresenter chronoPresenter = newPresenterOn(mockView);

        chronoPresenter.startChronometer();
        chronoPresenter.stopChronometer();
        chronoPresenter.continueChronometer();

        verify(mockView, times(2)).enableOnlyStopAndLapCommands();
        // una por el start, otra por el continue
    }

    @Test
    public void whenLappedOnlyStopAndContinueCmdsShouldBeEnabled() throws Exception {
        ChronometerPassiveView mockView = mock(ChronometerPassiveView.class);

        ChronometerPresenter chronoPresenter = newPresenterOn(mockView);

        chronoPresenter.startChronometer();
        chronoPresenter.lapChronometer();

        verify(mockView).enableOnlyStopAndContinueCommands();
    }

    @Test
    public void whenStartedDisplayShouldBeGray() throws Exception {
        ChronometerPassiveView mockView = mock(ChronometerPassiveView.class);

        ChronometerPresenter chronoPresenter = newPresenterOn(mockView);

        chronoPresenter.startChronometer();

        verify(mockView).changeDisplayColorToGray();
    }

    @Test
    public void whenStoppedDisplayShouldBeRed() throws Exception {
        ChronometerPassiveView mockView = mock(ChronometerPassiveView.class);

        ChronometerPresenter chronoPresenter = newPresenterOn(mockView);

        chronoPresenter.startChronometer();
        chronoPresenter.stopChronometer();

        verify(mockView).changeDisplayColorToRed();
    }

    @Test
    public void whenLappedDisplayShouldBeYellow() throws Exception {
        ChronometerPassiveView mockView = mock(ChronometerPassiveView.class);

        ChronometerPresenter chronoPresenter = newPresenterOn(mockView);

        chronoPresenter.startChronometer();
        chronoPresenter.lapChronometer();

        verify(mockView).changeDisplayColorToYellow();
    }

    @Test
    public void whenContinuedDisplayShouldBeGray() throws Exception {
        ChronometerPassiveView mockView = mock(ChronometerPassiveView.class);

        ChronometerPresenter chronoPresenter = newPresenterOn(mockView);

        chronoPresenter.startChronometer();
        chronoPresenter.stopChronometer();
        chronoPresenter.continueChronometer();

        verify(mockView, times(2)).changeDisplayColorToGray();
        // una por el start, otra por el continue
    }

    @Test
    public void whenChronometerChangeTheDisplayShouldBeUpdated() throws Exception {
        ChronometerPassiveView mockView = mock(ChronometerPassiveView.class);
        Chronometer chronometer = new Chronometer();

        ChronometerPresenter chronoPresenter = new ChronometerPresenter(mockView, chronometer);

        chronoPresenter.startChronometer();
        waitForATic();

        verify(mockView).updateDisplayWith(chronometer.getSeconds());
    }

    @SuppressWarnings("static-access")
    private void waitForATic() {
        try {
            Thread.currentThread().sleep(1100);
        } catch (InterruptedException e) {
            throw new UnsupportedOperationException();
        }
    }

    private ChronometerPresenter newPresenterOn(final ChronometerPassiveView mockView) {
        return new ChronometerPresenter(mockView, aChronometer);
    }

}
