package com.hexacta.hat.presentacion.mvc.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseCommand implements Command {

    protected HttpServletRequest request;

    protected ServletContext context;

    protected HttpServletResponse response;

    protected void forwardTo(final String target) {
        try {
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(target);
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    abstract public void execute();

    @Override
    public void init(final HttpServletRequest request, final ServletContext servletContext,
            final HttpServletResponse response) {
        this.request = request;
        context = servletContext;
        this.response = response;

    }

}