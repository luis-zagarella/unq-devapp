/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro.gui.mvp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Ventana que muestra el cronometro.
 * 
 * @author diego
 */
public class ChronometerWindowPVWithMenu extends Frame implements ChronometerPassiveView {

    private ChronometerPresenter myChronometerPresenter;

    private TextField displayTextField;

    private MenuItem startMenuItem;

    private MenuItem stopMenuItem;

    private MenuItem continueMenuItem;

    private MenuItem lapMenuItem;

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
        buildMenu();

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

    private void buildMenu() {
        Menu commandsMenu = buildCommandsMenu();

        buildStartMenuItemIn(commandsMenu);
        buildStopMenuItemIn(commandsMenu);
        buildContinueMenuItemIn(commandsMenu);
        buildLapMenuItemIn(commandsMenu);
    }

    private Menu buildCommandsMenu() {
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);
        Menu commandsMenu = new Menu("Commands");
        menuBar.add(commandsMenu);
        return commandsMenu;
    }

    private void buildStartMenuItemIn(final Menu menu) {
        startMenuItem = new MenuItem("START");
        startMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myChronometerPresenter.startChronometer();
            }
        });

        menu.add(startMenuItem);
    }

    private void buildStopMenuItemIn(final Menu menu) {
        stopMenuItem = new MenuItem("STOP");
        stopMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myChronometerPresenter.stopChronometer();
            }
        });

        menu.add(stopMenuItem);
    }

    private void buildContinueMenuItemIn(final Menu menu) {
        continueMenuItem = new MenuItem("CONTINUE");
        continueMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myChronometerPresenter.continueChronometer();
            }
        });

        menu.add(continueMenuItem);
    }

    private void buildLapMenuItemIn(final Menu menu) {
        lapMenuItem = new MenuItem("LAP");
        lapMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myChronometerPresenter.lapChronometer();
            }
        });

        menu.add(lapMenuItem);
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
        disableAllMenuItems();
        enableStartMenuItem();
        enableContinueMenuItem();
    }

    @Override
    public void enableOnlyStartCommand() {
        disableAllMenuItems();
        enableStartMenuItem();
    }

    @Override
    public void enableOnlyStopAndContinueCommands() {
        disableAllMenuItems();
        enableStopMenuItem();
        enableContinueMenuItem();
    }

    @Override
    public void enableOnlyStopAndLapCommands() {
        disableAllMenuItems();
        enableStopMenuItem();
        enableLapMenuItem();
    }

    @Override
    public void updateDisplayWith(final Integer seconds) {
        displayTextField.setText(seconds.toString());
    }

    private void enableContinueMenuItem() {
        continueMenuItem.setEnabled(true);
    }

    private void enableStartMenuItem() {
        startMenuItem.setEnabled(true);
    }

    private void enableStopMenuItem() {
        stopMenuItem.setEnabled(true);
    }

    private void enableLapMenuItem() {
        lapMenuItem.setEnabled(true);
    }

    private void disableAllMenuItems() {
        startMenuItem.setEnabled(false);
        stopMenuItem.setEnabled(false);
        continueMenuItem.setEnabled(false);
        lapMenuItem.setEnabled(false);
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
