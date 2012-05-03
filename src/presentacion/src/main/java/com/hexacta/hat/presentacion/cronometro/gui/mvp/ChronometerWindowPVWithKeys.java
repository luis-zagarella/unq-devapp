/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.gui.mvp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Ventana que muestra el cronometro.
 * 
 * @author diego
 */
public class ChronometerWindowPVWithKeys extends Frame implements ChronometerPassiveView {

    private ChronometerPresenter myChronometerPresenter;

    private TextField displayTextField;

    @Override
    public void init(final ChronometerPresenter aChronometerPresenter) {
        bindTo(aChronometerPresenter);
        buildWindow();
    }

    private void bindTo(final ChronometerPresenter aChronometerPresenter) {
        myChronometerPresenter = aChronometerPresenter;
    }

    private void buildWindow() {
        buildDisplay();
        bindsActionsKeys();

        configureWindow();
    }

    private void buildDisplay() {
        displayTextField = new TextField();
        displayTextField.setBackground(Color.GRAY);
        displayTextField.setEditable(false);
        displayTextField.setFont(new Font("Dialog", 0, 72));
        displayTextField.setText("0");

        add(displayTextField);
    }

    private void bindsActionsKeys() {
        displayTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                switch (e.getKeyCode()) {
                case KeyEvent.VK_Q:
                    myChronometerPresenter.startChronometer();
                    break;
                case KeyEvent.VK_W:
                    myChronometerPresenter.stopChronometer();
                    break;
                case KeyEvent.VK_A:
                    myChronometerPresenter.continueChronometer();
                    break;
                case KeyEvent.VK_S:
                    myChronometerPresenter.lapChronometer();
                    break;
                default:
                    break;
                }
            }
        });
    }

    @Override
    public void changeDisplayColorToGray() {
        displayTextField.setBackground(Color.GRAY);
    }

    @Override
    public void changeDisplayColorToRed() {
        displayTextField.setBackground(Color.RED);
    }

    @Override
    public void changeDisplayColorToYellow() {
        displayTextField.setBackground(Color.YELLOW);
    }

    @Override
    public void enableOnlyStartAndContinueCommands() {
    }

    @Override
    public void enableOnlyStartCommand() {
    }

    @Override
    public void enableOnlyStopAndContinueCommands() {
    }

    @Override
    public void enableOnlyStopAndLapCommands() {
    }

    @Override
    public void updateDisplayWith(final Integer seconds) {
        displayTextField.setText(seconds.toString());
    }

    private void configureWindow() {
        setTitle("Cronometro con Menu :)");
        setSize(250, 150);
        setVisible(true);
        setCloseWindowHandler();
    }

    private void setCloseWindowHandler() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent evt) {
                exitForm(evt);
            }
        });
    }

    private void exitForm(final WindowEvent evt) {
        System.exit(0);
    }

    private static final long serialVersionUID = -4421146734839866767L;
}
