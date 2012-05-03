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
public class ChronometerWindowInlined extends Frame implements Observer {

    private final Chronometer chronometer;

    private final TextField displayTextField;

    public ChronometerWindowInlined(final Chronometer aChronometer) {
        // bind chronometer
        chronometer = aChronometer;
        chronometer.addObserver(this);

        // build display
        displayTextField = new TextField();
        displayTextField.setBackground(Color.GRAY);
        displayTextField.setEditable(false);
        displayTextField.setFont(new Font("Dialog", 0, 72));
        displayTextField.setText("0");

        add(displayTextField);

        // build buttons
        Panel buttonsPanel = new Panel();
        buttonsPanel.setLayout(new GridLayout(2, 2));

        add(buttonsPanel);

        // start button
        final Button startButton = new Button("START");
        final Button stopButton = new Button("STOP");
        final Button continueButton = new Button("CONTINUE");
        final Button lapButton = new Button("LAP");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                continueButton.setEnabled(false);
                lapButton.setEnabled(true);
                displayTextField.setBackground(GRAY);

                chronometer.start();
            }
        });

        buttonsPanel.add(startButton);

        // stop button
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                stopButton.setEnabled(false);
                startButton.setEnabled(true);
                continueButton.setEnabled(true);
                lapButton.setEnabled(false);
                displayTextField.setBackground(RED);

                chronometer.stop();
            }
        });

        buttonsPanel.add(stopButton);

        // continue button
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                continueButton.setEnabled(false);
                lapButton.setEnabled(true);
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                displayTextField.setBackground(GRAY);

                chronometer.continuue();
            }
        });

        buttonsPanel.add(continueButton);

        // lap button
        lapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                lapButton.setEnabled(false);
                continueButton.setEnabled(true);
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                displayTextField.setBackground(YELLOW);

                chronometer.lap();
            }
        });

        buttonsPanel.add(lapButton);

        // config window
        setTitle("Cronometro Inlined! :)");
        setSize(300, 250);
        setLayout(new GridLayout(2, 1));
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent evt) {
                System.exit(0);
            }
        });
    }

    @Override
    public void update(final Observable o, final Object arg) {
        displayTextField.setText(arg.toString());
    }

    private static final long serialVersionUID = -4421146734839866767L;
}
