/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.gui.mvp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Ventana que muestra el cronometro.
 * 
 * @author diego
 */
public class ChronometerWindowPassiveView extends JFrame implements ChronometerPassiveView {

    private ChronometerPresenter myChronometerPresenter;

    private JTextField displayTextField;

    private JButton startButton;

    private JButton stopButton;

    private JButton lapButton;

    private JButton continueButton;

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
        buildButtons();

        configureWindow();
    }

    private void buildDisplay() {
        displayTextField = new JTextField();
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

    private void buildStartButtonIn(final Panel aPanel) {
        startButton = new JButton("START");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myChronometerPresenter.startChronometer();
            }
        });

        aPanel.add(startButton);
    }

    private void buildStopButtonIn(final Panel aPanel) {
        stopButton = new JButton("STOP");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myChronometerPresenter.stopChronometer();
            }
        });

        aPanel.add(stopButton);
    }

    private void buildLapButtonIn(final Panel aPanel) {
        lapButton = new JButton("LAP");
        lapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myChronometerPresenter.lapChronometer();
            }
        });

        aPanel.add(lapButton);
    }

    private void buildContinueButtonIn(final Panel aPanel) {
        continueButton = new JButton("CONTINUE");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myChronometerPresenter.continueChronometer();
            }
        });

        aPanel.add(continueButton);
    }

    private void configureWindow() {
        setTitle("Cronometro version: Passive View  :)");
        setSize(300, 250);
        setLayout(new GridLayout(2, 1));
        setVisible(true);
        setCloseWindowHandler();
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
        disableAllButtons();
        enableStartButton();
        enableContinueButton();
    }

    @Override
    public void enableOnlyStartCommand() {
        disableAllButtons();
        enableStartButton();
    }

    @Override
    public void enableOnlyStopAndContinueCommands() {
        disableAllButtons();
        enableStopButton();
        enableContinueButton();
    }

    @Override
    public void enableOnlyStopAndLapCommands() {
        disableAllButtons();
        enableStopButton();
        enableLapButton();
    }

    @Override
    public void updateDisplayWith(final Integer seconds) {
        displayTextField.setText(seconds.toString());
    }

    private void enableContinueButton() {
        continueButton.setEnabled(true);
    }

    private void enableStartButton() {
        startButton.setEnabled(true);
    }

    private void enableStopButton() {
        stopButton.setEnabled(true);
    }

    private void enableLapButton() {
        lapButton.setEnabled(true);
    }

    private void disableAllButtons() {
        startButton.setEnabled(false);
        stopButton.setEnabled(false);
        continueButton.setEnabled(false);
        lapButton.setEnabled(false);
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
