package com.hexacta.hat.presentacion.mvc.web.frontcontroller;

import com.hexacta.hat.presentacion.mvc.web.support.PlantillaDeEstudiantes;

public class ExisteEstudianteCommand extends BaseCommand {

    private final PlantillaDeEstudiantes plantillaDeEstudiantes;

    public ExisteEstudianteCommand(final PlantillaDeEstudiantes plantillaDeEstudiantes) {
        this.plantillaDeEstudiantes = plantillaDeEstudiantes;
    }

    @Override
    public void execute() {
        Boolean rta = plantillaDeEstudiantes.existe(nombreDeEstudianteABuscar());
        setRespuestaEnPagina(rta);

        forwardTo("/busquedaEstudianteResultPage.jsp");
    }

    private String nombreDeEstudianteABuscar() {
        return request.getParameter("nombreDelEstudianteABuscar");
    }

    private void setRespuestaEnPagina(final Boolean rta) {
        request.setAttribute("existeEstudiante", rta);
    }

}
