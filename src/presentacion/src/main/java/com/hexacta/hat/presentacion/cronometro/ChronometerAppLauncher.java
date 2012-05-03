/**
 * 
 */
package com.hexacta.hat.presentacion.cronometro;

import com.hexacta.hat.presentacion.cronometro.gui.ChronometerWindow;
import com.hexacta.hat.presentacion.cronometro.gui.ChronometerWindowInlined;
import com.hexacta.hat.presentacion.cronometro.gui.mvp.ChronometerPresenter;
import com.hexacta.hat.presentacion.cronometro.gui.mvp.ChronometerWindowPVWithKeys;
import com.hexacta.hat.presentacion.cronometro.gui.mvp.ChronometerWindowPVWithMenu;
import com.hexacta.hat.presentacion.cronometro.gui.mvp.ChronometerWindowPassiveView;
import com.hexacta.hat.presentacion.cronometro.model.Chronometer;

/**
 * Lanza la app chronometro.
 * 
 * @author diego
 */
@SuppressWarnings("unused")
public class ChronometerAppLauncher {

    public static void main(final String[] args) {
         //showChronometerApp();
         showChronometerAppInlined();
         //showChronometerAppEstiloPassiveView();
         //showChronometerAppEstiloPassiveViewWithMenu();
         //showChronometerAppEstiloPassiveViewWithKeys();
    }

    private static void showChronometerApp() {
        ChronometerWindow.openOn(new Chronometer());
    }

    private static void showChronometerAppInlined() {
        new ChronometerWindowInlined(new Chronometer());
    }

    private static void showChronometerAppEstiloPassiveView() {
        ChronometerPresenter.startOn(new ChronometerWindowPassiveView(), new Chronometer());
    }

    private static void showChronometerAppEstiloPassiveViewWithMenu() {
        ChronometerPresenter.startOn(new ChronometerWindowPVWithMenu(), new Chronometer());
    }

    private static void showChronometerAppEstiloPassiveViewWithKeys() {
        ChronometerPresenter.startOn(new ChronometerWindowPVWithKeys(), new Chronometer());
    }
}
