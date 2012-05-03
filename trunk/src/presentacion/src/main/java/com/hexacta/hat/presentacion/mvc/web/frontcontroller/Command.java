package com.hexacta.hat.presentacion.mvc.web.frontcontroller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    void execute();

    void init(HttpServletRequest request, ServletContext servletContext, HttpServletResponse response);

}
