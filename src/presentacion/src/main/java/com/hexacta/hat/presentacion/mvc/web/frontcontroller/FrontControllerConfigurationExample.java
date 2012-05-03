package com.hexacta.hat.presentacion.mvc.web.frontcontroller;

import static com.hexacta.hat.presentacion.mvc.web.frontcontroller.FrontController.aFrontController;

@SuppressWarnings("unused")
public class FrontControllerConfigurationExample {

    private FrontController frontController;

    //@formatter:off
	public void config() {
		frontController = aFrontController()
							 .map("existeEstudiante").to (ExisteEstudianteCommand.class)
							 .map("guardarDocente")  .to (GuardarDocenteCommand.class);
	}

}
