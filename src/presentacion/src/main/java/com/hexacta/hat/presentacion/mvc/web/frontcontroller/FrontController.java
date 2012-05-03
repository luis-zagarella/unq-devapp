package com.hexacta.hat.presentacion.mvc.web.frontcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

    private static final String COMMAND_PARAM = "command";

    private final Map<String, Class<? extends Command>> commandsMap = new HashMap<String, Class<? extends Command>>();

    private String commandKey;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {

        Command command = newCommandFor(request, getServletContext(), response);

        command.execute();
    }

    private Command newCommandFor(final HttpServletRequest request, final ServletContext servletContext,
            final HttpServletResponse response) {
        Class<? extends Command> commandClass = commandsMap.get(extractCommandNameFrom(request));

        Command command = instantiate(commandClass);
        command.init(request, servletContext, response);

        return command;
    }

    private Command instantiate(final Class<? extends Command> commandClass) {
        if (commandClass == null) {
            return new UnknowCommand();
        }

        return newInstanceOf(commandClass);
    }

    private Command newInstanceOf(final Class<? extends Command> commandClass) {
        try {
            return commandClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String extractCommandNameFrom(final HttpServletRequest request) {
        return request.getParameter(COMMAND_PARAM);
    }

    public static FrontController aFrontController() {
        return new FrontController();
    }

    public FrontController map(final String command) {
        commandKey = command;
        return this;
    }

    public FrontController to(final Class<? extends Command> commandnClass) {
        if (commandKey == null) {
            throw new RuntimeException("no existe key para asociar con este comando");
        }
        commandsMap.put(commandKey, commandnClass);

        return this;
    }

    private static final long serialVersionUID = 2945651106038078853L;
}
