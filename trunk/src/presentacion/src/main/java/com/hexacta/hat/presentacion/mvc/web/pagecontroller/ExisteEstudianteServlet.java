package com.hexacta.hat.presentacion.mvc.web.pagecontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hexacta.hat.presentacion.mvc.web.support.PlantillaDeEstudiantes;

public class ExisteEstudianteServlet extends HttpServlet {

    private final PlantillaDeEstudiantes plantillaDeEstudiantes;

    public ExisteEstudianteServlet(final PlantillaDeEstudiantes plantillaDeEstudiantes) {
        this.plantillaDeEstudiantes = plantillaDeEstudiantes;
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        String nombreDelEstudianteABuscar = extractNombreDelEstudianteABuscarFrom(request);

        Boolean rta = plantillaDeEstudiantes.existe(nombreDelEstudianteABuscar);

        writeOutput(rta, nombreDelEstudianteABuscar, response);
    }

    private void writeOutput(final Boolean rta, final String nombreEstudiante, final HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (rta) {
            out.println(simpleHTMLWithP("Estudiante: " + nombreEstudiante + " existente"));
        } else {
            out.println(simpleHTMLWithP("Estudiante: " + nombreEstudiante + " no existente"));
        }
    }

    private String simpleHTMLWithP(final String pText) {
        return "<html><body><p>" + pText + "</p></body></html>";
    }

    private String extractNombreDelEstudianteABuscarFrom(final HttpServletRequest request) {
        return request.getParameter("nombreDelEstudianteABuscar");
    }

    private static final long serialVersionUID = 2419409564985958571L;

}
