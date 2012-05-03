/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.gui;

import static java.awt.Color.*;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import com.hexacta.hat.presentacion.cronometro.model.Chronometer;

/**
 * Ventana que muestra el cronometro.
 * 
 * @author diego
 */
public class ChronometerWindow extends Frame implements Observer {

    private Chronometer chronometer;

    private TextField displayTextField;

    private Button startButton;

    private Button stopButton;

    private Button lapButton;

    private Button continueButton;

    public static void openOn(final Chronometer aChronometer) {
        new ChronometerWindow(aChronometer);
    }

    public ChronometerWindow(final Chronometer aChronometer) {
        bindTo(aChronometer);
        buildWindow();
    }

    private void bindTo(final Chronometer aChronometer) {
        chronometer = aChronometer;
        chronometer.addObserver(this);
    }

    private void buildWindow() {
        buildDisplay();
        buildButtons();

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

    private void buildButtons() {
        Panel buttonsPanel = buildButtonsPanel();

        buildStartButtonIn(buttonsPanel);
        buildStopButtonIn(buttonsPanel);
        buildContinueButtonIn(buttonsPanel);
        buildLapButtonIn(buttonsPanel);
    }

    private Panel buildButtonsPanel() {
        Panel buttonsPanel = new Panel();
        buttonsPanel.setLayout(new GridLayout(2, 2));

        add(buttonsPanel);

        return buttonsPanel;
    }

    @Override
    public void update(final Observable o, final Object arg) {
        displayTextField.setText(arg.toString());
    }

    private void buildStartButtonIn(final Panel aPanel) {
        startButton = new Button("START");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                switchStartToStopAction();
                switchContinueToLapAction();
                changeDisplayColorTo(GRAY);

                chronometer.start();
            }
        });

        aPanel.add(startButton);
    }

    private void buildStopButtonIn(final Panel aPanel) {
        stopButton = new Button("STOP");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                switchStopToStartAction();
                switchLapToContinueAction();
                changeDisplayColorTo(RED);

                chronometer.stop();
            }

        });
        stopButton.setEnabled(false);
        aPanel.add(stopButton);
    }

    private void buildLapButtonIn(final Panel aPanel) {
        lapButton = new Button("LAP");
        lapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                switchLapToContinueAction();
                switchStartToStopAction();
                changeDisplayColorTo(YELLOW);

                chronometer.lap();
            }
        });

        lapButton.setEnabled(false);
        aPanel.add(lapButton);
    }

    private void buildContinueButtonIn(final Panel aPanel) {
        continueButton = new Button("CONTINUE");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                switchContinueToLapAction();
                switchStartToStopAction();
                changeDisplayColorTo(GRAY);

                chronometer.continuue();
            }
        });
        continueButton.setEnabled(false);

        aPanel.add(continueButton);
    }

    private void switchStartToStopAction() {
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    private void switchStopToStartAction() {
        stopButton.setEnabled(false);
        startButton.setEnabled(true);
    }

    private void switchContinueToLapAction() {
        continueButton.setEnabled(false);
        lapButton.setEnabled(true);
    }

    private void switchLapToContinueAction() {
        lapButton.setEnabled(false);
        continueButton.setEnabled(true);
    }

    private void changeDisplayColorTo(final Color aColor) {
        displayTextField.setBackground(aColor);
    }

    private void configureWindow() {
        setTitle("Cronometro :)");
        setSize(300, 250);
        setLayout(new GridLayout(2, 1));
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
